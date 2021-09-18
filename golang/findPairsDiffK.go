package main

import (
	"log"
)

// findPairs 返回 nums 里所有差为 k 的唯一组合数。
//
// k 大于 0。
func findPairs(nums []int, k int) int {
	if len(nums) < 2 {
		return 0
	}

	idx := 0
	ret := []int{}
	ans := [][]int{}

	ans = findPair(nums, idx, k, ret, ans)
	return len(ans)
}

func findPair(nums []int, idx, k int, ret []int, ans [][]int) [][]int {
	if idx >= len(nums) {
		return ans
	}

	if len(ret) == 2 {
		if absReduce(ret[0], ret[1]) == k {
			found := false
			for _, an := range ans {
				if (an[0] == ret[0] && an[1] == ret[1]) ||
					(an[0] == ret[1] && an[1] == ret[0]) {
					found = true
				}
			}

			if !found {
				ans = append(ans, ret)
			}
		}

		return ans
	}

	ans = findPair(nums, idx+1, k, ret, ans)

	//1,4,3,5
	if len(ret) < 2 {
		ret = append(ret, nums[idx])
		ans = findPair(nums, idx, k, ret, ans)
		ret = ret[:len(ret)-1]
	}

	return ans
}

func absReduce(i, j int) int {
	val := j - i
	if i > j {
		val = i - j
	}

	if val < 0 {
		return -val
	}

	return val
}

func main() {
	if findPairs([]int{}, 2) != 0 {
		log.Fatal("error")
	}
	if findPairs([]int{1}, 2) != 0 {
		log.Fatal("error")
	}
	if findPairs([]int{1, 3}, 2) != 1 {
		log.Fatal("error")
	}
	// 有 (1, 3), (3, 5) 两种组合；注意 1 在数组里出现两次，在组合里不重复计算。
	if findPairs([]int{3, 1, 4, 1, 5}, 2) != 2 {
		log.Fatal("error")
	}
	if findPairs([]int{1, 1, 1, 1, 1}, 2) != 0 {
		log.Fatal("error")
	}
	if findPairs([]int{1, 1, 1, 2, 2}, 1) != 1 {
		log.Fatal("error")
	}
}
