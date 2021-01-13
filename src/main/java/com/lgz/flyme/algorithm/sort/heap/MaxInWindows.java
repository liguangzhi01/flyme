package com.lgz.flyme.algorithm.sort.heap;

import java.util.*;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度的时候，返回空
 *
 * @author: liguangzhi01
 * @date: 2021/1/11
 */
public class MaxInWindows {

    public static void main(String[] args) {

        int[] arr = {2,3,4,2,6,2,5,1};

        ArrayList<Integer> integers = maxInWindows(arr, 3);
        System.out.println(integers);




    }

    // ???????  双端单调递减队列，  应该使用ArrayList 还是用LindedList?
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();

        if (size > num.length || size < 1) {
            return result;
        }
        // 队列存的是数组下标
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {

            // 1、 从尾向头遍历队列， 队列中元:xx,  若num[xx] <= num[i], 则从队列中移除xx
            while (queue.size() > 0) {
                Integer last = queue.getLast();
                if (num[last] > num[i]) {
                    break;
                }
                queue.removeLast();
            }
            // 判断队列头部元素，是否还在窗口内
            if(!queue.isEmpty() && i - queue.peek() >= size) {
                queue.poll();
            }
            queue.add(i);
            if(i >= size - 1) {
                result.add(num[queue.peek()]);
            }
        }
        return result;
    }
    public static ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();

        if (size > num.length || size < 1) {
            return result;
        }
        // 队列存的是数组下标
        ArrayList<Integer> queue = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {

            // 1、 从尾向头遍历队列， 队列中元:xx,  若num[xx] <= num[i], 则从队列中移除xx
            while (queue.size() > 0) {
                Integer last = queue.get(queue.size() - 1);
                if (num[last] > num[i]) {
                    break;
                }
                queue.remove(queue.size() - 1);
            }
            // 判断队列头部元素，是否还在窗口内
            if(!queue.isEmpty() && (i - queue.get(0) >= size)) {
                queue.remove(0);
            }
            queue.add(i);
            if(i >= size - 1) {
                result.add(num[queue.get(0)]);
            }
        }
        return result;
    }

    public static int[]  randomArr(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = random.nextInt(size * 2);
        }
        return arr;
    }

}
