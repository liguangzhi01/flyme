package com.lgz.flyme.common;

/**
 * @author: liguangzhi01
 * @date: 2021/1/9
 */
public class ArrayUtils {

    public static <T> void printArr(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }


    public static  void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }

    public static <T> T[] swap(T[] array, int i, int j) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException("Number array must not empty !");
        }
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        return array;
    }

    public static int[] swap(int[] array, int i, int j) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException("Number array must not empty !");
        }
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        return array;
    }

    public static <T> boolean isEmpty(final T... array) {
        return array == null || array.length == 0;
    }


}
