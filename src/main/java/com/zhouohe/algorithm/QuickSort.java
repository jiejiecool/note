package com.zhouohe.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 快排
 */
public class QuickSort {
    @Test
    public void test1() {
        int[] arr = new int[]{4,2,6,5,10,14,9,611,123,43,32,45,221};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //排序
    private void sort(int[] arr, int p, int r){
        if (p >= r) {
            return;
        }
        int q = particpantArr(arr, p, r);
        sort(arr, p, q);
        sort(arr, q+1, r);
    }

    //找到key，并将大于key的划分到右边数组，小于key的划分到左边数组
    private int particpantArr(int[] arr, int p, int r) {

        int randomNum = getRandomNum(p, r);
        exchange(arr, randomNum, r);
        int i = p;

        // i是小于x的数组的右下标
        // i+1 是大于x的数组的左下标 j 是大于key的右边下标
        for (int q = p; q < r; q++) {
            if (arr[q] <= arr[r]) {
                //放进左边数组
                i++;
                exchange(arr, i-1, q);
            }
        }
        exchange(arr, i, r);
        return i;
    }

    //交换
    private void exchange(int[] arr, int randomNum, int r) {
        if (randomNum == r) {
            return;
        }
        int tmpNum = arr[randomNum];
        arr[randomNum] = arr[r];
        arr[r]  = tmpNum;
    }

    private int getRandomNum(int left, int right){
        return new Random().nextInt(right - left + 1) + left;
    }
}
