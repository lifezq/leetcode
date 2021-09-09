package main

import (
	"fmt"
	"time"
)

var (
	idx  = 0
	data = make(chan int, 100)
)

func sendData(data chan<- int) {

	tm := time.Tick(time.Second * 10)
	for {
		select {
		case <-tm:
			return
		default:
			data <- idx
			fmt.Println("------------------------", idx)
			idx++
			time.Sleep(time.Millisecond * 500)
		}
	}
}

func receiveData(data <-chan int) {
	for {
		select {
		case val := <-data:
			fmt.Println("received data:", val)
		default:
			time.Sleep(time.Second)
		}
	}
}

func main() {
	go sendData(data)
	go receiveData(data)
	select {}
}
