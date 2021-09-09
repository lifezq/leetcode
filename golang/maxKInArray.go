package main

import "fmt"

// [1, 2, 5, 3, 4, 6] 3
func maxK(arr []int, k int) []int {
	maxKArr := make([]int, k)
	for _, v := range arr {
		if len(maxKArr) < k {
			maxKArr = append(maxKArr, v)
		}

		var min int = maxKArr[0]
		var minIdx int = 0
		for i, v1 := range maxKArr {
			if v1 < min {
				min = v1
				minIdx = i
			}
		}

		if v > min {
			maxKArr[minIdx] = v
		}
	}

	return maxKArr
}

func main() {
	arr := []int{1, 2, 5, 3, 4, 6}
	result := maxK(arr, 3)
	for _, v := range result {
		fmt.Printf("%d,", v)
	}
}
