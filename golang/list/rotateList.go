package main

import (
	"fmt"
	"math"
)

type Node2 struct {
	val  int
	next *Node2
}

func rotateRight(head *Node2, k int) *Node2 {
	node := head
	idx := 0
	for node != nil {
		idx++
		node = node.next
	}

	if idx == k {
		return head
	}

	if k > idx {
		k = k % idx
	}

	newHead := head
	for i := 0; i < k; i++ {
		newHead = rotateNode(newHead)
	}

	return newHead
}

func rotateNode(head *Node2) *Node2 {
	newHead := head
	tailNode := &Node2{
		val: math.MinInt64,
	}
	newTailNode := tailNode

	for newHead.next != nil {
		if tailNode.val == math.MinInt64 {
			tailNode.val = newHead.val
			if newHead.next.next != nil {
				tailNode.next = &Node2{
					val: math.MinInt64,
				}
			}
			tailNode = tailNode.next
		}
		newHead = newHead.next
	}

	return &Node2{
		val:  newHead.val,
		next: newTailNode,
	}
}

func main() {
	head := &Node2{
		val: 1,
		next: &Node2{
			val: 2,
			next: &Node2{
				val: 3,
				next: &Node2{
					val: 4,
					next: &Node2{
						val: 5,
					},
				},
			},
		},
	}

	ret := rotateRight(head, 3)
	for ret != nil {
		fmt.Printf("%d,", ret.val)
		ret = ret.next
	}
}
