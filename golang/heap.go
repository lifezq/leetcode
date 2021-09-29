package main

import (
	"fmt"
	"math"
)

//堆树的定义如下：
//
//（1）堆树是一颗完全二叉树；
//
//（2）堆树中某个节点的值总是不大于或不小于其孩子节点的值；
//
//（3）堆树中每个节点的子树都是堆树。
//
//当父节点的键值总是大于或等于任何一个子节点的键值时为最大堆。 当父节点的键值总是小于或等于任何一个子节点的键值时为最小堆。如下图所示，左边为最大堆，右边为最小堆。

/**
  最小堆实现思路：
  数组0存放临时元素
*/
type MinHeap struct {
	elements []int
}

func NewMinHeap() *MinHeap {
	return &MinHeap{elements: []int{math.MinInt64}}
}

func (h *MinHeap) Insert(arr ...int) {
	if len(arr) == 0 {
		return
	}

	h.elements = append(h.elements, arr...)
	h.heapify()
}

/*
   弹出顶端最小元素
   如果没有，返回-1
*/
func (h *MinHeap) Pop() int {
	if len(h.elements) <= 1 {
		return -1
	}

	v := h.elements[1]
	h.elements = append(h.elements[:1], h.elements[2:]...)
	h.heapify()
	return v
}

/**
  向最小堆里添加元素
*/
func (h *MinHeap) Push(v int) {
	h.Insert(v)
}

/**
  堆化：当添加或删除元素时
*/
func (h *MinHeap) heapify() {
	// 元素0存放临时元素，同时意味着下标从1开始计算！！！！
	//[-1,1,2,3,4]
	for i := len(h.elements) / 2; i > 0; i-- {

		h.elements[0] = h.elements[i]

		son := i * 2
		for son < len(h.elements) {
			if son+1 < len(h.elements) && h.elements[son] > h.elements[son+1] {
				son++
			}

			if h.elements[son] > h.elements[0] {
				break
			}

			h.elements[son/2] = h.elements[son]
			son *= 2
		}

		h.elements[son/2] = h.elements[0]
	}
}

func main() {
	myHeap := NewMinHeap()
	myHeap.Insert([]int{43, 23, 49, 54, 65, 8787, 8, 5}...)
	for v := myHeap.Pop(); v != -1; v = myHeap.Pop() {
		fmt.Printf("%d,", v)
	}
}
