package main

import "fmt"

//区间合并问题
//
//S=([1,3],[5,7],[9,11])   满足两个条件：左区间升序排列(1,5,9)，区间互不相交
//
//K=[2,8]  将K插入到S中，使得S扔满足两个特性
//
//output: ([1,8],[9,11])
//step1:[1,3],[2,8],[5,7],[9,11]
func arrayRangeMerge(s [][]int, k []int) [][]int {
	s = append(s, k)
	for i := 0; i < len(s); i++ {
		for j := i + 1; j < len(s); j++ {
			if s[i][0] > s[j][0] {
				s[i], s[j] = s[j], s[i]
			}
		}
	}

	merge := [][]int{}
	for i := 0; i < len(s); i++ {
		left, right := s[i][0], s[i][1]
		if len(merge) == 0 || merge[len(merge)-1][1] < left {
			merge = append(merge, s[i])
		} else {
			maxRight := right
			if merge[len(merge)-1][1] > maxRight {
				maxRight = merge[len(merge)-1][1]
			}
			merge[len(merge)-1][1] = maxRight
		}
	}
	return merge
}

func main() {
	s := [][]int{
		{1, 3},
		{5, 7},
		{9, 11},
	}

	ans := arrayRangeMerge(s, []int{2, 8})
	for _, an := range ans {
		fmt.Printf("%d,%d\n", an[0], an[1])
	}
}
