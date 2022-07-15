package com.yql.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Array {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        String key = "he";
        System.out.println(key.hashCode());
        hashMap.put(null, "ddddd");
        System.out.println("is big endian:" + new Array().isBigEndian() + "---" + hashMap.get(null));
        
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

    public boolean isBigEndian() {
        int a = 0x01234567;
        if (0x01 == (byte) a) {
            return true;
        }
        return false;
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
