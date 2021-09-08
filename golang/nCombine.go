package main

import "fmt"

/*
 给一个数组和参数n，返回由n 组成所有组合
例：1, 2, 3,    参数n=2
返回：
3,3,
2,3,
2,2,
1,3,
1,2,
1,1,
*/
func nCombine(arr []int, n int) [][]int {

	if len(arr) < n {
		return [][]int{arr}
	}

	res := [][]int{}
	cur := []int{}
	dfs1(arr, 0, n, &res, &cur)

	return res
}

func dfs1(arr []int, idx, n int, res *[][]int, cur *[]int) {
	if idx > len(arr)-1 {
		return
	}

	if len(*cur) == n {
		current := []int{}
		for _, v := range *cur {
			current = append(current, v)
		}
		*res = append(*res, current)
		return
	}

	dfs1(arr, idx+1, n, res, cur)

	if len(*cur) < n {
		*cur = append(*cur, arr[idx])
		dfs1(arr, idx, n, res, cur)
		*cur = (*cur)[0 : len((*cur))-1]
	}
}

func main() {
	arr := []int{
		1, 2, 3,
	}

	res := nCombine(arr, 2)
	fmt.Printf("res-----------len:%d\n", len(res))
	for i := range res {
		for i2 := range res[i] {
			fmt.Print(res[i][i2], ",")
		}
		fmt.Println(" ")
	}
}
