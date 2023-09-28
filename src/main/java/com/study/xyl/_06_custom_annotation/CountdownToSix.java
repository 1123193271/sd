package com.study.xyl._06_custom_annotation;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Duration;

public class CountdownToSix {

    public static void main(String[] args) {
        // 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime.toLocalTime());

        // 设置目标时间为六点
        LocalTime targetTime = LocalTime.of(18, 0); // 六点的时间

        // 计算距离目标时间的持续时间
        Duration duration = Duration.between(currentTime.toLocalTime(), targetTime);
        long secondsUntilSix = duration.getSeconds();

        System.out.println("距离六点还有 " + secondsUntilSix + " 秒");

        // 进行倒计时
        while (secondsUntilSix > 0) {
            try {
                Thread.sleep(1000); // 暂停一秒钟
                secondsUntilSix--;
                System.out.println("距离六点还有 " + secondsUntilSix + " 秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 倒计时结束后输出消息
        System.out.println("已经六点了！");
    }
}

