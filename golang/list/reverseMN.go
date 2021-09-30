package main

import "fmt"

type Node struct {
	val  int
	next *Node
}

func reverseMN(head *Node, m, n int) *Node {
	var newHead *Node
	var headNode *Node = &Node{
		val: head.val,
	}
	tailNode := &Node{val: -1}

	newHeadNode := headNode
	newTailNode := tailNode
	idx := 0
	for head != nil {
		idx++

		if idx > 1 && idx < m {
			headNode.next = &Node{
				val: head.val,
			}
			headNode = headNode.next
		}

		if idx >= m && idx <= n {
			temp := head.next
			head.next = newHead
			newHead = head
			head = temp
			continue
		}

		if idx > n {
			headNode.next = newHead
			if tailNode.val == -1 {
				tailNode.val = head.val
			} else {
				tailNode.next = &Node{
					val: head.val,
				}

				tailNode = tailNode.next
			}
		}

		head = head.next
	}

	temp := newHead
	for temp.next != nil {
		temp = temp.next
	}

	temp.next = newTailNode

	return newHeadNode
}

func main() {
	head := &Node{
		val: 1,
		next: &Node{
			val: 2,
			next: &Node{
				val: 3,
				next: &Node{
					val: 4,
					next: &Node{
						val: 5,
					},
				},
			},
		},
	}

	ret := reverseMN(head, 3, 4)

	for ret != nil {
		fmt.Printf("%d,", ret.val)
		ret = ret.next
	}
}
