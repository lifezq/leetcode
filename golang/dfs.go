package main

import (
	"fmt"
)

type Node2 struct {
	val   int
	left  *Node2
	right *Node2
}

func dfs2(node *Node2, level int, k *int) int {
	if node == nil {
		return *k
	}

	if level > *k {
		*k = level
	}

	fmt.Printf("%d,", node.val)

	dfs2(node.left, level+1, k)
	dfs2(node.right, level+1, k)

	return *k
}

func maxDepth(node *Node2) int {
	if node == nil {
		return 0
	} else {
		leftHeight := maxDepth(node.left)
		rightHeight := maxDepth(node.right)
		return max(leftHeight, rightHeight) + 1
	}
}

func max(i1, i2 int) int {
	if i1 > i2 {
		return i1
	}

	return i2
}

func main() {
	var head *Node2 = &Node2{
		val: 1,
		left: &Node2{
			val: 2,
			left: &Node2{
				val: 4,
			},
			right: &Node2{
				val: 5,
			},
		},
		right: &Node2{
			val: 3,
			left: &Node2{
				val: 6,
			},
			right: &Node2{
				val: 7,
			},
		},
	}

	k := 0
	fmt.Printf("二叉树dfs获取深度为：%d\n", dfs2(head, 1, &k))
	fmt.Printf("二叉树maxDepth获取深度为：%d\n", maxDepth(head))
}
