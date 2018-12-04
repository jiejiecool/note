package com.zhouohe.algorithm;

/**
 * 时间复杂度为n来计算最大子数组
 */
public class MaxSumSubArrayDynamic {
    public static void main(String[] args) {
        int []arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        int MAX_SUM = 0;
        int currentSum = 0;
        int low = 0;
        int high = arr.length;

        for (int i = 0; i < arr.length; i++ ) {
            currentSum += arr[i];

            if (currentSum >= MAX_SUM) {
                high = i;
                MAX_SUM = currentSum;
            }

            if (currentSum <= 0) {
                currentSum = 0;
                low = i + 1;
                high = i + 1;
            }
        }

        System.out.println(new Arr(low, high, MAX_SUM));

    }
}
