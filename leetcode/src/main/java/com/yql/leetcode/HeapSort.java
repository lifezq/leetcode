package com.yql.leetcode;

import java.util.Arrays;

/**
 * @Author Ryan
 * @Date 2022/7/25
 */
public class HeapSort {

    public static int[] sort(int[] data) {
        int[] res = new int[data.length];
        int length = data.length;
        int idx = 0;

        while (idx < length) {
            heapify(data);
            res[idx] = data[0];
            data = Arrays.copyOfRange(data, 1, data.length);
            idx++;
        }

        return res;
    }

    public static void heapify(int[] data) {
        int idx = data.length / 2;
        while (idx >= 0) {
            shiftDown(data, idx);
            idx--;
        }
    }

    public static void shiftDown(int[] data, int idx) {
        int size = data.length;
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;

        while (left < size || right < size) {
            int leftValue = left < size ? data[left] : Integer.MAX_VALUE;
            int rightValue = right < size ? data[right] : Integer.MAX_VALUE;
            int next = leftValue > rightValue ? right : left;

            if (data[idx] < data[next]) {
                break;
            } else {
                swap(data, idx, next);
                idx = next;
                left = idx * 2 + 1;
                right = idx * 2 + 2;
            }
        }
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
