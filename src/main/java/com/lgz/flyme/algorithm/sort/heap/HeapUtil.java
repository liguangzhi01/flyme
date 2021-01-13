package com.lgz.flyme.algorithm.sort.heap;

import com.lgz.flyme.common.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liguangzhi01
 * @date: 2021/1/9
 */
public class HeapUtil {


    public static void main(String[] args) {

        Integer[] arr = {7, 5, 229, 8, 4, 1, 20, 13, 199};
        ArrayUtils.printArr(arr);
        heapSort(arr, arr.length);
        ArrayUtils.printArr(arr);


    }

    /**
     * 堆排序 ： 建立大顶堆， 堆顶元素即为整个数组最大值， 将堆顶元素与数组末尾的元素交换，再将剩下的元素重新堆化。
     *
     * @param arr
     * @return:
     */
    public static void heapSort(Integer[] arr, int n) {
        // 1、 首先建立大顶堆， 建立完之后， 堆顶元素为最大元素
        buildHeap(arr, n);
        int i = n - 1;
        while (i >= 1) {
            // 将堆顶元素与 数组后面的元素交换
            ArrayUtils.swap(arr, 0, i);
            // i及以后的元素已经有序了
            i--;
            heapify(arr, i, 0);
        }

    }


    /**
     * 数组建堆
     *
     * @param arr
     * @param n   堆的大小
     * @return:
     */
    public static void buildHeap(Integer[] arr, int n) {
        if (n > arr.length) {
            throw new IllegalArgumentException("n must be less than the length of arr");
        }

        /**
         * 数组包含n个元素， 则从[(n/2, n -1] 内的元素是没有叶子节点， 不需要堆化
         * 从[0, n/2 - 1], 开始堆化数组
         */
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, n - 1, i);
        }
    }

    /**
     * 从上到下 数组堆化， 堆化之后的结果： startIndex的元素， 一定是以此节点为根节点的堆的最大值(注意： 并不是从startIndex--endIndex的最大值)
     *
     * @param arr
     * @param endIndex   堆化的时候不能超过此下标
     * @param startIndex 堆化开始的节点下标，
     * @return:
     */
    private static void heapify(Integer[] arr, int endIndex, int startIndex) {
        while (true) {
            // arr[startIndex]的左节点下标
            int left = 2 * startIndex + 1;
            // arr[startIndex]的右节点下标
            int right = 2 * startIndex + 2;
            int maxIndex = startIndex;
            if (left <= endIndex && arr[maxIndex] < arr[left]) {
                maxIndex = left;
            }
            if (right <= endIndex && arr[maxIndex] < arr[right]) {
                maxIndex = right;
            }
            if (startIndex == maxIndex) {
                break;
            }
            ArrayUtils.swap(arr, startIndex, maxIndex);
            startIndex = maxIndex;
        }
    }


    /**
     * 寻找 TOP K
     *
     * @param input
     * @param k
     * @return
     */
    public static List<Integer> GetLeastNumbers_Solution(Integer[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }


    public static void heap(Integer[] arr, int startIndex, int endIndex) {
        int parentIndex = startIndex / 2;
        int k = startIndex;
        while (k > 0) {
            if (arr[parentIndex] > arr[k]) {
                break;
            }
            ArrayUtils.swap(arr, parentIndex, k);
            k = parentIndex;
            parentIndex = parentIndex / 2;

        }
    }


    /**************  下面的是采用从下到上堆化， 数组从前到后依次堆化

     public static void heap(Integer[] arr, int startIndex) {
     int parentIndex = startIndex / 2;
     int k = startIndex;
     while (k > 0) {
     if (arr[parentIndex] > arr[k]) {
     break;
     }
     ArrayUtils.swap(arr, parentIndex, k);
     k = parentIndex;
     parentIndex = parentIndex / 2;

     }
     }
     public static void buildHeap2(Integer[] arr, int endIndex) {
     for (int i = 1; i <= endIndex; i++) {
     heap(arr, i);
     }
     }
     public static void heapSort2(Integer[] arr) {

     for (int i = arr.length - 1; i >= 1; i--) {
     buildHeap2(arr, i);
     ArrayUtils.swap(arr, 0, i);
     }


     }
     */

}
