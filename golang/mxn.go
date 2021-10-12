package main

import "fmt"

//3, 4, 5, 6
//7, 8, 5, 4
//2, 7, 8, 9

func mxnRightPrint(arr [][]int) []int {
	m, n := len(arr), len(arr[0])
	ret := []int{}
	for k := 0; k < n*2; k++ {
		for j := 0; j < m; j++ {
			for i := 0; i < n; i++ {
				if (i + j) == k {
					ret = append(ret, arr[j][n-1-i])
				}
			}
		}
	}

	return ret
}

func main() {
	ret := mxnRightPrint([][]int{
		{3, 4, 5, 6},
		{7, 8, 5, 4},
		{2, 7, 8, 9},
	})

	for _, v := range ret {
		fmt.Printf("%d,", v)
	}
}
