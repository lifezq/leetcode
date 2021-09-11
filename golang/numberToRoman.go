package main

import (
	"fmt"
	"strings"
)

// I 1
// V 5
// X 10
// L 50
// C 100
// D 500
// M 1000

//  特殊情况
//
// I 可以放在V（5）和X（10）的左边，来表示4 和9
// X 可以放在L(50)和C（100）的左边，来表示40和90
// C 可以放在D(500)和M （1000） 的左边，来表示400 和900
//  整数范围1-3999
// 题目：整数转罗马数字

var (
	s = []string{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"}
	n = []int{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000}
)

func numberToRoman(i int) string {

	// 923
	ret := ""
	for j := len(n) - 1; j >= 0; j-- {
		if i < n[j] {
			continue
		}

		num := i / n[j]
		ret = ret + strings.Repeat(s[j], num)

		i = i - num*n[j]
	}

	return ret
}

func main() {
	i := 923
	fmt.Printf("%d->%s\n", i, numberToRoman(i))
}
