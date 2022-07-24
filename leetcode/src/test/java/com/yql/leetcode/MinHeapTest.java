package com.yql.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @Package com.yql.leetcode
 * @ClassName MinHeapTest
 * @Description TODO
 * @Author Ryan
 * @Date 2022/7/23
 */
public class MinHeapTest {
    @Test
    public void testMinHeap() {
        MinHeap mh = new MinHeap();
        mh.add(new int[]{
                10, 2, 3, 44, 556, 77, 344, 33, 22, 98, 55, 66
        });
        mh.print();
    }

    @Test
    public void testMaxHeap() {
        MaxHeap mh = new MaxHeap();
        mh.add(new int[]{
                10, 2, 3, 44, 556, 77, 344, 33, 22, 98, 55, 66
        });
        mh.print();
    }
}
