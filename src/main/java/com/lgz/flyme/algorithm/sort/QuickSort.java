package com.lgz.flyme.algorithm.sort;

import com.lgz.flyme.common.ArrayUtils;

/**
 * @author: liguangzhi01
 * @date: 2021/1/11
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {74, 53, 22, 84, 41, 13, 26, 93, 99};
        ArrayUtils.printArr(arr);
        quickSort(arr, 0, arr.length -1 );
        ArrayUtils.printArr(arr);

    }

    public static void quickSort(int[]arr, int p, int q) {
        if (p >= q ) {
            return;
        }
        int partion = partion(arr, p, q);
        quickSort(arr, p, partion -1);
        quickSort(arr, partion + 1, q);

    }

    public static int partion(int[] arr, int p, int q) {
        int pivot = arr[q];
        int i = p;
        for (int j = p; j < q; j++) {
            if (pivot > arr[j]) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, q);
        return i;
    }
    public static void swap(int[]arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
