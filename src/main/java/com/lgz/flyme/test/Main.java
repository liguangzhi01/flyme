package com.lgz.flyme.test;

/**
 * @author: liguangzhi01
 * @date: 2021/1/12
 */

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("准备齐全"));


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                20,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(200));

        threadPoolExecutor.submit(new MeetingThread(cyclicBarrier));
        threadPoolExecutor.submit(new MeetingThread(cyclicBarrier));
        threadPoolExecutor.submit(new MeetingThread(cyclicBarrier));

        Thread.sleep(30000);
        threadPoolExecutor.shutdown();
    }




}


class MeetingThread implements Runnable {

    private CyclicBarrier cyclicBarrier;


    public MeetingThread(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "已经到达");

            cyclicBarrier.await();
            System.out.println(threadName + "开始开会");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}