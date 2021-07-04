package io.github.jeanhwea.lang.thd;

import java.util.concurrent.*;

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
    // test02();
    // test03();
    test04();
  }

  private static void doWork() {
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

  private static void phaserInfo(Phaser phaser) {
    System.out.printf(
        "阶段[%s][到达数=%d,未到达数=%d,总数=%d]\n",
        phaser.getPhase(),
        phaser.getArrivedParties(),
        phaser.getUnarrivedParties(),
        phaser.getRegisteredParties());
  }

  public static void test03() throws InterruptedException {
    Phaser phaser = new Phaser(5);
    phaserInfo(phaser);
    for (int i = 0; i < 10; i++) {
      Thread t =
          new Thread(
              () -> {
                doWork();
                System.out.printf("玩家[%s]准备就绪\n", Thread.currentThread().getName());
                phaser.arriveAndAwaitAdvance();
                System.out.printf("玩家[%s]选择英雄\n", Thread.currentThread().getName());
              });
      t.start();
    }
  }

  public static void test04() throws InterruptedException {
    Phaser phaser = new Phaser(5);
    phaserInfo(phaser);
    for (int i = 0; i < 10; i++) {
      Thread t =
          new Thread(
              () -> {
                doWork();
                System.out.printf("玩家[%s]准备就绪\n", Thread.currentThread().getName());
                phaser.arrive();
                phaserInfo(phaser);
                System.out.printf("玩家[%s]选择英雄\n", Thread.currentThread().getName());
              });
      t.start();
    }
    // phaser.awaitAdvance(0);
    phaser.awaitAdvance(phaser.getPhase());
    System.out.println("房间[0]游戏开始");
    phaser.awaitAdvance(phaser.getPhase());
    System.out.println("房间[1]游戏开始");
  }
}
