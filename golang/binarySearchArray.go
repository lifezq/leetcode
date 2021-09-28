package main

import (
	"fmt"
)

/**
  在有序数组中
  二分查找，如果没有找到返回-1，找到返回在数组中key索引值
*/
func binarySearch2(arr []int, k int) int {
	if len(arr) == 0 {
		return -1
	}

	var middle int
	left, right := 0, len(arr)-1
	for left <= right {
		middle = (left + right) / 2
		if arr[middle] > k {
			right = middle
		} else if arr[middle] < k {
			left = middle
		} else {
			return middle
		}
	}

	return -1
}

func max2(a, b int) int {
	if a > b {
		return a
	}

	return b
}

func main() {
	k := 88
	fmt.Printf("二分查找值：%d，在数组中索引为：%d\n", k, binarySearch2([]int{2, 34, 55, 56, 65, 88, 657, 984, 9954}, k))
}
