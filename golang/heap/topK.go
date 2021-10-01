package main

import (
	"fmt"
	"math"
)

//最小堆实现最大topk
type TopK struct {
	//元素0为临时元素
	elements []int
	topK     int
}

func NewTopK(topK int) *TopK {
	if topK < 1 {
		topK = 1
	}

	return &TopK{
		elements: []int{math.MinInt64},
		topK:     topK,
	}
}

func (t *TopK) Insert(e ...int) {

	elems := []int{}
	for _, v := range e {
		ok := true
		if len(t.elements)-1 == t.topK && v < t.elements[1] {
			ok = false
		}

		if ok {
			elems = append(elems, v)
		}
	}

	if len(elems) == 0 {
		return
	}

	t.elements = append(t.elements, elems...)

	t.heapify()

	for len(t.elements)-1 > t.topK {
		t.elements = append(t.elements[0:1], t.elements[2:]...)
		t.heapify()
	}
}

func (t *TopK) topList() []int {
	return t.elements[1:]
}

func (t *TopK) heapify() {
	length := len(t.elements)
	for i := length / 2; i > 0; i-- {
		t.elements[0] = t.elements[i]
		son := i * 2
		for son < length {
			if son+1 < length && t.elements[son] > t.elements[son+1] {
				son++
			}

			if t.elements[son] > t.elements[son/2] {
				break
			}

			t.elements[son/2] = t.elements[son]
			son *= 2
		}

		t.elements[son/2] = t.elements[0]
	}
}

func main() {
	topK := NewTopK(5)
	topK.Insert([]int{43, 656, 76, 899, 798, 9, 90, 54, 54, 87, 898, 4554, 54}...)
	topK.Insert([]int{547, 76, 768, 798, 98, 34, 4, 5, 5656, 7, 67, 7878, 78, 5454}...)
	list := topK.topList()
	fmt.Println(list)
}
