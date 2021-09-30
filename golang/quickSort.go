package main

import "fmt"

func quickSort(arr []int, low, high int) {
	if len(arr) == 0 || low >= high {
		return
	}

	i, j := low, high
	pivot := arr[i]
	for i < j {
		if i < j && arr[j] >= pivot {
			j--
		}
		if i < j {
			arr[i] = arr[j]
		}

		if i < j && arr[i] <= pivot {
			i++
		}
		if i < j {
			arr[j] = arr[i]
		}
	}

	arr[i] = pivot

	quickSort(arr, low, i)
	quickSort(arr, i+1, high)
}

func main() {
	arr := []int{43, 435, 65, 676, 678, 787, 343476, 8778}
	quickSort(arr, 0, len(arr)-1)
	fmt.Println(arr)
}
