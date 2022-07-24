package com.yql.leetcode;

import java.util.Arrays;

/**
 * @Dest 最大堆，找最小值
 * @Author lifez
 * @Date 2022/7/24
 */
public class MaxHeap {
    private int[] data;
    private int topK;

    public MaxHeap() {
        this(10);
    }

    public MaxHeap(int topK) {
        this.topK = topK;
        data = new int[this.topK + 1];
        Arrays.fill(data, Integer.MIN_VALUE);
    }

    public void add(int v) {
        data[0] = v;
        int idx = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == Integer.MIN_VALUE) {
                idx = i;
                break;
            }
        }

        if (idx > 0) {
            data[idx] = v;
        } else {
            heapify();
        }
    }

    public void add(int[] v) {
        for (int i : v) {
            add(i);
        }
    }

    public int[] topK() {
        return Arrays.copyOfRange(data, 1, data.length);
    }

    public void print() {
        System.out.println("maxHeap:" + Arrays.toString(topK()));
    }

    public void heapify() {
        int i = (topK + 1) / 2;
        while (i >= 0) {
            shiftDown(i);
            i--;
        }
    }

    public void shiftDown(int i) {
        int left, right;

        left = i * 2 + 1;
        right = i * 2 + 2;

        while (left <= topK || right <= topK) {

            int leftValue = left <= topK ? data[left] : Integer.MIN_VALUE;
            int rightValue = right <= topK ? data[right] : Integer.MIN_VALUE;
            int next = leftValue > rightValue ? left : right;

            if (data[i] > data[next]) {
                break;
            } else {
                swap(i, next);

                i = next;
                left = i * 2 + 1;
                right = i * 2 + 2;
            }
        }
    }

    public void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
