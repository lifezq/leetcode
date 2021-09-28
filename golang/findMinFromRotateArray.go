package main

import (
	"fmt"
)

//已知一个长度为 n 的元素互不相同的数组，预先按照升序排列。然后我们将该数组分成两部分并进行一次旋转，
//例如[1, 2, 3, 4, 5, 6] -> [4, 5, 6,1, 2, 3]。请找出并返回数组中的最小元素。
//
//input1: [3, 4, 5, 1,2]
//output: 1
//
//input2: [2, 3, 4, 5, 1]
//output:1
//
//input3: [1,2, 3, 4, 5]
//output: 1

func find(arr []int) int {
	return binarySearch(arr)
	//return findItem(arr, arr[0])
}

func binarySearch(arr []int) int {

	if len(arr) == 0 {
		return 0
	}

	min := arr[0]
	left, right := 0, len(arr)-1
	for left >= 0 && right < len(arr) && left < right {
		if arr[left] < min {
			min = arr[left]
		}
		if arr[right] < min {
			min = arr[right]
		}

		if arr[left] > arr[right] {
			left = (left+right)/2 + 1
		} else {
			right = (left+right)/2 - 1
		}
	}
	return min
}

func findItem(arr []int, min int) int {
	left := 0
	right := len(arr) - 1
	if left == right {
		return min
	}
	if arr[left] < min {
		min = arr[left]
	}
	if arr[right] < min {
		min = arr[right]
	}

	if arr[left] < arr[right] {
		min = findItem(arr[:len(arr)/2], min)
	} else {
		min = findItem(arr[len(arr)/2:], min)
	}
	return min
}

func main() {
	fmt.Printf("最小值：%d\n", find([]int{2, 3, 4, 5, 1}))
}
