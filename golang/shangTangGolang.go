package main

import "fmt"

type SS struct {
	Age int
}

type I interface {
	Get() int
	Set(int)
}

func (s SS) Get() int { return s.Age }

func (s SS) Set(age int) { s.Age = age }

func main() {

	ss := SS{}

	ss.Set(10)

	fmt.Println(ss.Get())

	var s *SS

	fmt.Println(s == nil)

	var i I = s

	fmt.Println(i == nil)
}

//output:
//0
//true
//false
