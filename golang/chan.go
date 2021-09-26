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

func nilChan(cc chan<- int) {
	cc <- 11
}

func main() {
	//go sendData(data)
	//go receiveData(data)

	/*
		//当向nilchannel时，不可读，也不可写
		var c1 chan int
		go nilChan(c1)
		d := <-c1
		fmt.Printf("c1.val:%d\n", d)
	*/

	/*
				var c2 = make(chan int)
				go nilChan(c2)
				d := <-c2
		fmt.Printf("c2.val:%d\n", d)
	*/

	/*
		//无缓冲通道，当无数据时读会阻塞
		d = <-c2
		fmt.Printf("c2.val:%d\n", d)
	*/
	/*
	   //当关闭通道后，读会返回对应0值，写会panic: send on closed channel
	*/
	/*
		close(c2)
		d = <-c2
		fmt.Printf("c2.val:%d\n", d)
		c2 <- 55
		* /

	*/
	fmt.Println("running...")
	//select {}
}
