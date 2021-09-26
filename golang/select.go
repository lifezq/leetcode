package main

import (
	"fmt"
	"time"
)

func main() {
	tm := time.Tick(time.Second * 5)
	fmt.Println("starting...")
	select {
	case <-tm:
		fmt.Println("超时...")
	}
	fmt.Println("running...")
}
