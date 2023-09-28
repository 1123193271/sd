package com.study.xyl._06_custom_annotation;

import java.time.LocalTime;
import java.time.Duration;

public class CountdownToSixMilliseconds {

    public static void main(String[] args) {
        // 设置目标时间为六点
        LocalTime targetTime = LocalTime.of(18, 0); // 六点的时间

        // 计算距离目标时间的持续时间
        Duration duration = Duration.between(LocalTime.now(), targetTime);
        long millisecondsUntilSix = duration.toMillis();

        System.out.println("距离六点还有 " + millisecondsUntilSix + " 毫秒");

        // 进行倒计时
        while (millisecondsUntilSix > 0) {
            try {
                Thread.sleep(100); // 暂停100毫秒
                millisecondsUntilSix -= 100;
                System.out.println("距离六点还有 " + millisecondsUntilSix + " 毫秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 倒计时结束后输出消息
        System.out.println("已经六点了！");
    }
}

