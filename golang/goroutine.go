package main

import "time"

var a string
var limit = make(chan int, 3)

func f() {
	print(a)
}

func hello() {
	a = "hello, world"
	go f()
}

func goroutineLimit() {
	work := []func(){f}
	for _, w := range work {
		go func(w func()) {
			limit <- 1
			w()
			<-limit
		}(w)
	}
}

func happensBefore() {
	var i int = 5
	go func() {
		i = 10
	}()
	for l := 0; l < 100; l++ {
		println(i)
	}
}

func main() {
	hello()
	goroutineLimit()
	happensBefore()
	time.Sleep(time.Second * 5)
}
