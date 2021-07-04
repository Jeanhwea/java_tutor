package io.github.jeanhwea.lang.thd;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * JUC 中常见的同步工具
 *
 * @author Jinghui Hu
 * @since 2021-07-04, JDK1.8
 */
@SuppressWarnings("all")
public class Runner03 {

  public static void main(String[] args) throws InterruptedException {
    // test01();
    test02();
  }

  public static void doWork() {
    try {
      Thread.sleep(new Double(Math.random() * 3000).longValue());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void test01() throws InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(5);
    for (int i = 0; i < 5; i++) {
      Thread t =
          new Thread(
              () -> {
                doWork();
                countDownLatch.countDown(); // 不阻塞
                System.out.printf("玩家[%s]准备就绪\n", Thread.currentThread().getName());
              });
      t.start();
    }
    countDownLatch.await(); // 阻塞
    System.out.println("游戏开始");
  }

  public static void test02() throws InterruptedException {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
    for (int i = 0; i < 10; i++) {
      Thread t =
          new Thread(
              () -> {
                doWork();
                try {
                  System.out.printf("玩家[%s]准备就绪\n", Thread.currentThread().getName());
                  cyclicBarrier.await(); // 不阻塞，达到循环数字时所有线程同时唤醒，并循环利用
                  System.out.printf("玩家[%s]选择英雄\n", Thread.currentThread().getName());
                } catch (InterruptedException | BrokenBarrierException e) {
                  e.printStackTrace();
                }
              });
      t.start();
    }
  }
}
