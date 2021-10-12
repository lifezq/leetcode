package main

import (
	"fmt"
	"unsafe"
)

type W struct {
	b int32
	c int64
}

func ptrInt(i *int) {
	*i = 11
	fmt.Printf("2.ptrInt.变量i值为：%d，指针存的地址：%v，地址：%v\n", *i, &(*i), &i)
}

func sliceArg(s []int) {
	s[0] = 222
	fmt.Printf("2.sliceArg变更s值为：%v，地址：%v %v\n", s, &s[0], &s)
}

func main() {
	var w *W = new(W)
	//这时w的变量打印出来都是默认值0，0
	fmt.Println(w.b, w.c)

	//现在我们通过指针运算给b变量赋值为10
	b := unsafe.Pointer(uintptr(unsafe.Pointer(w)) + unsafe.Offsetof(w.b))
	*((*int)(b)) = 10
	//此时结果就变成了10，0
	fmt.Println(w.b, w.c)

	i := 0
	fmt.Printf("1.变量i值为：%d，地址：%v\n", i, &i)
	ptrInt(&i)
	fmt.Printf("3.变量i值为：%d，地址：%v\n", i, &i)

	s := []int{111}
	fmt.Printf("1.变量s值为：%d，地址：%v %v\n", s, &s[0], &s)
	sliceArg(s)
	fmt.Printf("3.变量s值为：%d，地址：%v %v\n", s, &s[0], &s)
}
