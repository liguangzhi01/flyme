package com.lgz.flyme.algorithm;

/**
 * @author: liguangzhi01
 * @date: 2021/1/12
 */
public class MaxWater {

    public static void main(String[] args) {
        int[] arr = {3,1,2,5,2,4};
        System.out.println(maxWater(arr));
    }

    public static long maxWater(int[] arr) {
        // write code here
        if (arr == null || arr.length < 3) {
            return 0L;
        }
        long capacity = 0L;
        int leftBorder = arr[0];
        int rightBorder = arr[arr.length - 1];

        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        while (leftIndex < rightIndex) {
            leftBorder = Math.max(arr[leftIndex], leftBorder);
            rightBorder = Math.max(arr[rightIndex], rightBorder);
            if(leftBorder < rightBorder) {
                capacity += leftBorder - arr[leftIndex];
                leftIndex ++;
            } else {
                capacity += rightBorder - arr[rightIndex];
                rightIndex --;
            }
        }
        return capacity;

    }
}
