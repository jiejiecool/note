package com.zhouohe.algorithm;

public class Arr {

    int left;
    int right;
    int sum;

    public Arr(int left, int right, int sum) {
        this.left = left;
        this.right = right;
        this.sum = sum;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Arr{" +
                "left=" + left +
                ", right=" + right +
                ", sum=" + sum +
                '}';
    }

}
