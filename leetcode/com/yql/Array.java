package com.yql;

import java.util.ArrayList;
import java.util.List;

public class Array {
    public static void main(String[] args) {
        Array array = new Array();
        int[] arr = new int[3];
        arr[0] = 111;
        array.arrayArgs(arr);
        System.out.printf("arr.o:%d\n", arr[0]);

        List<Integer> list = new ArrayList<>();
        list.add(222);
        array.arrayList(list);
        System.out.printf("arr.o:%d\n", list.get(0));
    }

    public void arrayArgs(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        arr[arr.length - 1] = arr.length;
    }

    public void arrayList(List<Integer> list) {
        if (list.size() == 0) {
            return;
        }

        list.set(0, list.size());
    }
}
