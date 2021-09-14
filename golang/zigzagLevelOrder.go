package main

import "fmt"

type TreeNode struct {
	val   int
	left  *TreeNode
	right *TreeNode
}

func main() {
	head := &TreeNode{
		val: 1,
		left: &TreeNode{
			val: 2,
			left: &TreeNode{
				val: 4,
			},
			right: &TreeNode{
				val: 5,
			},
		},
		right: &TreeNode{
			val: 3,
			left: &TreeNode{
				val: 6,
				left: &TreeNode{
					val: 8,
				},
				right: &TreeNode{
					val: 9,
				},
			},
			right: &TreeNode{
				val: 7,
			},
		},
	}

	ans := zigzagLeverOrder(head)
	for _, an := range ans {
		for _, v := range an {
			fmt.Printf("%d,", v)
		}

		fmt.Println(" ")
	}
}

func zigzagLeverOrder(head *TreeNode) [][]int {
	if head == nil {
		return nil
	}

	var node *TreeNode
	ans := [][]int{}
	isLeftOrder := true
	q := []*TreeNode{head}
	for len(q) > 0 {
		levelList := []int{}
		size := len(q)
		for i := 0; i < size; i++ {
			node = q[0]
			q = q[1:]

			if isLeftOrder {
				levelList = append(levelList, node.val)
			} else {
				newQ := []int{node.val}
				newQ = append(newQ, levelList...)
				levelList = newQ
			}

			if node.left != nil {
				q = append(q, node.left)
			}

			if node.right != nil {
				q = append(q, node.right)
			}
		}

		ans = append(ans, levelList)
		isLeftOrder = !isLeftOrder
	}
	return ans
}
