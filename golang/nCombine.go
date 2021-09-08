package main

/*
 给一个数组和参数n，返回由n 组成所有组合
*/
func nCombine(arr []int, n int) [][]int {

	if len(arr) < n {
		return [][]int{arr}
	}

	res := [][]int{}
	cur := []int{}
	dfs1(arr, 0, n, &res, &cur)

	return nil
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

	dfs1(arr)

}

func main() {
	arr := []int{
		1, 2, 3, 4,
	}

	nCombine(arr, 2)
}
