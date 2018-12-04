package com.zhouohe.algorithm;

/**
 * 和最大子数组
 *
 * 一个数组中最大的子数组，要么位于数组中间点的左边，要么位于数组中间点的右边
 * 要么横跨中间点。
 *
 * input: a[]
 * output: left,right,subSum(和最大子数组的左边下标，右边下标和和)
 */
public class MaxSumSubArrayRecursive {

    public static void main(String[] args) {
        //int []arr = new int[]{1,2,3,4,5,6};
        int []arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(GET_MAX_ARR(arr,0,arr.length-1));
        //System.out.println(GET_MAX_CROSS_ARR(arr,0,arr.length-1));
    }

    static Arr GET_MAX_ARR(int[] arr,int low, int high){
        if (low == high) return new Arr(low,low, arr[low]);

        int mid = (low + high) /2;
        //左边最大
        Arr left = GET_MAX_ARR(arr, low, mid);

        //右边最大
        Arr rigth = GET_MAX_ARR(arr, mid+1, high);

        //跨越中点最大
        Arr cross = GET_MAX_CROSS_ARR(arr, low, high);

        if (left.sum >= rigth.sum && left.sum >= cross.sum) {
            return left;
        }else if (rigth.sum >= left.sum && rigth.sum >= cross.sum) {
            return rigth;
        } else {
            return cross;
        }

    }
    /**
     * 获得跨越中点的最大子数组，由中点往左右分别延伸，时间复杂度为O(n)
     * @param low
     * @param high
     * @return
     */
    static Arr GET_MAX_CROSS_ARR(int[] arr, int low, int high) {
        int mid = (low + high) / 2; //向下取整

        int leftSum = 0;//记录左边最大的和
        int rightSum = 0;//记录右边最大的和
        int left = mid;//左边最大值的位置
        int right = mid;//右边最大值的位置

        int sum = 0; //记录当前和
        //从中点左前一位寻找最大和
        for (int i = mid-1; i >= low; i--) {
            sum += arr[i];
            if (sum >= leftSum) {
                leftSum = sum;
                left = i;
            }
        }

        //从中点向右寻找最大和
        sum = 0;
        for (int i = mid; i <= high; i++) {
            sum += arr[i];
            if (sum >= rightSum) {
                rightSum = sum;
                right = i;
            }
        }


        return  new Arr(left, right, leftSum+rightSum);
    }


}
