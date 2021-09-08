package main

import (
	"fmt"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func hasLinkedListCycle(node *ListNode) (*ListNode, int, bool) {

	var walker *ListNode = node
	var runner *ListNode = node
	var hasCycle bool = false
	for runner != nil && runner.Next != nil {
		walker = walker.Next
		runner = runner.Next.Next
		if walker == runner {
			hasCycle = true
			break
		}
	}

	if !hasCycle {
		return nil, 0, hasCycle
	}

	length := 1
	var entry *ListNode = walker
	for walker.Next != entry {
		length++
		walker = walker.Next
	}

	var head *ListNode = node
	var cross *ListNode = entry
	for head != cross {
		head = head.Next
		cross = cross.Next
	}

	return cross, length, hasCycle
}

func main() {
	listNode := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val: 3,
				Next: &ListNode{
					Val: 4,
					Next: &ListNode{
						Val: 5,
					},
				},
			},
		},
	}

	listNode.Next.Next.Next.Next.Next = listNode.Next.Next

	node, length, hasCycle := hasLinkedListCycle(listNode)

	fmt.Printf("node:%v length:%d hasCycle:%v\n", node, length, hasCycle)
	if hasCycle {
		fmt.Println("node.val:", node.Val)
	}
}
