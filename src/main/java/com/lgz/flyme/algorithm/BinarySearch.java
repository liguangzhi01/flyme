package com.lgz.flyme.algorithm;

/**
 * @author: liguangzhi01
 * @date: 2021/1/12
 */
public class BinarySearch {
    public static void main(String[] args) {


        int[] arr = {2,3,3,97,97,99};

        System.out.println(upper_bound(6, 1, arr));





    }


    /**请实现有重复数字的有序数组的二分查找。
     输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
     *
     *
     * 二分查找  数组为升序， 但是数组内可能有重复值
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public static int upper_bound (int n, int v, int[] a) {
        // write code here


        int left = 0;
        int right = n ;
        int mid = 0;
        while(left < right) {
            mid = left + ((right - left)>>1);
            if(a[mid] >= v) right = mid ;
            else  left = mid + 1;
        }
        return left + 1;
    }
}
