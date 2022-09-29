package com.google.showcase.v1beta1.interview.q3;

import java.util.Random;

// 03. 请实现一个多线程任务执行器
public class ThreadPoolTaskExecutor {
    public static Random random = new Random();

    public static int[] tasks = new int[100000];

    static {
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = i;
        }
    }

    // 这是我们需要执行的方法。
    public static void execute(int taskId) throws InterruptedException {
        Thread.sleep(random.nextInt(500));
        System.out.println(taskId);
    }

    // 请在这里实现多线程的任务执行器。
    public static void main(String[] args) {

    }
}
