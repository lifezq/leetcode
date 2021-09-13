package main

import "fmt"

type Node1 struct {
	val   int
	left  *Node1
	right *Node1
}

func bfs(node *Node1) int {
	if node == nil {
		return 0
	}

	level := 0
	temp := &Node1{}
	list := []*Node1{node}
	for len(list) > 0 {
		size := len(list)
		for i := 0; i < size; i++ {
			temp = list[0]
			fmt.Printf("%d,", temp.val)
			if temp.left != nil {
				list = append(list, temp.left)
			}

			if temp.right != nil {
				list = append(list, temp.right)
			}

			list = list[1:]
		}

		fmt.Println("")
		level++
	}

	return level
}

func main() {
	var head *Node1 = &Node1{
		val: 1,
		left: &Node1{
			val: 2,
			left: &Node1{
				val: 4,
			},
			right: &Node1{
				val: 5,
			},
		},
		right: &Node1{
			val: 3,
			left: &Node1{
				val: 6,
			},
			right: &Node1{
				val: 7,
			},
		},
	}

	fmt.Printf("二叉树bfs获取深度为：%d\n", bfs(head))
}
