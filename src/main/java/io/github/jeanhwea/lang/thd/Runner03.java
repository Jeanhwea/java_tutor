package io.github.jeanhwea.lang.thd;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * JUC 中常见的同步工具
 *
 * @author Jinghui Hu
 * @since 2021-07-04, JDK1.8
 */
@SuppressWarnings("all")
public class Runner03 {

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
                System.out.printf("玩家[%s]准备就绪\n", Thread.currentThread().getName());
                countDownLatch.countDown();
              });
      t.start();
    }
    countDownLatch.await();
    System.out.println("游戏开始");
  }

  public static void main(String[] args) throws InterruptedException {
    test01();
  }
}
