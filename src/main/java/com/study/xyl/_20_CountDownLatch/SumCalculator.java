package com.study.xyl._20_CountDownLatch;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumCalculator extends RecursiveTask<Integer> {

    private final int[] array;
    private final int start;
    private final int end;

    public SumCalculator(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 100000000) { // 如果任务足够小，直接计算结果
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else { // 否则拆分任务
            int middle = (start + end) / 2;
            SumCalculator leftTask = new SumCalculator(array, start, middle);
            SumCalculator rightTask = new SumCalculator(array, middle, end);
            leftTask.fork(); // 异步执行左子任务
            int rightResult = rightTask.compute(); // 同步执行右子任务
            int leftResult = leftTask.join(); // 获取左子任务的结果
            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[1000000000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000); // 生成 0 到 999 之间的随机整数
        }
        long startTime1 = System.currentTimeMillis();
        int result1 = 0;
        for (int j : array) {
            result1 += j;
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("time1: " + (endTime1 - startTime1));
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long startTime2 = System.currentTimeMillis();
        int result2 = forkJoinPool.invoke(new SumCalculator(array, 0, array.length));
        long endTime2 = System.currentTimeMillis();
        System.out.println("time2: " + (endTime2 - startTime2));
        System.out.println("Sum: " + result1);
        System.out.println("Sum: " + result2);
    }
}
