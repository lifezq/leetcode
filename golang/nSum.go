package main

import (
	"fmt"
	"reflect"
)

/*
  给一个数组和参数n、target，返回所有满足长度为n，且和为target 的组合
  如：1, 2, -3, 4, -2, -2     参数：n=3, target=0
  返回：
     	4,-2,-2,
		1,2,-3,
		1,1,-2,
*/
func nSum(arr []int, n, target int) [][]int {
	if len(arr) < 3 {
		return nil
	}

	res := [][]int{}
	cur := []int{}
	idx := 0
	dfs(arr, idx, n, target, &res, &cur)
	return res
}

func dfs(arr []int, idx, n, target int, res *[][]int, cur *[]int) {
	if idx >= len(arr) || len(*cur) > 3 {
		return
	}

	if len(*cur) == n {
		sum := 0
		for _, v := range *cur {
			sum += v
		}

		if sum == target {

			var current []int
			for _, v := range *cur {
				current = append(current, v)
			}

			found := false
			for _, v := range *res {
				if reflect.DeepEqual(v, current) {
					found = true
				}
			}

			if !found {
				*res = append(*res, current)
			}
		}

		return
	}

	dfs(arr, idx+1, n, target, res, cur)

	if idx < len(arr) && len(*cur) < 3 {
		*cur = append(*cur, arr[idx])
		dfs(arr, idx, n, target, res, cur)
		*cur = (*cur)[0 : len(*cur)-1]
	}

	return
}

//给一个数组，找到三个元素和为0，且不重复
func main() {
	arr := []int{
		1, 2, -3, 4, -2, -2,
	}

	res := nSum(arr, 3, 0)
	fmt.Printf("res-----------len:%d\n", len(res))
	for i := range res {
		for i2 := range res[i] {
			fmt.Print(res[i][i2], ",")
		}
		fmt.Println(" ")
	}
}
