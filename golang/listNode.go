package main

import "fmt"

type Node struct {
	val  int
	next *Node
}

func reverse(n *Node) *Node {
	var head *Node
	var temp *Node

	for n != nil {
		temp = n.next
		n.next = head
		head = n
		n = temp
	}

	return head
}

func main() {
	n := Node{
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

	head := reverse(&n)

	for head != nil {
		fmt.Printf("%d->", head.val)
		head = head.next
	}
}
