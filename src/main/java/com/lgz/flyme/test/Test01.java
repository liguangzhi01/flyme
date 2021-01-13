package com.lgz.flyme.test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author: liguangzhi01
 * @date: 2021/1/12
 */
public class Test01 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // push  pop

        Queue<Integer> queue = new ArrayDeque<>();

        // offer  put 阻塞
        // pool   take 阻塞

        int k = 8 - 4>>>1;
        System.out.println(k);

        DynamicLinkedBlockingQueue<Runnable> taskQueue = new DynamicLinkedBlockingQueue(10);

        ArrayBlockingQueue<Runnable> workerQueue = new ArrayBlockingQueue<>(300);


        for ( int i = 0; i < 15; i++) {
            System.out.println("线程数量：" + i);
//            if(i >= 10) {
//                taskQueue.setCapacity(20);
//            }
            taskQueue.add(() -> System.out.println("---" ));
        }


    }
}


