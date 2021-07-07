package io.github.jeanhwea.lang.juc;

import java.util.concurrent.CountDownLatch;

public class Runner06 {

  // 这里如果不添加 volatile 关键字子线程只能读到 flag 为 true
  private static /* volatile */ boolean flag = true;

  public static void test01() throws InterruptedException {
    Thread t =
        new Thread(
            () -> {
              while (flag) {
                // 死循环，线程不能终止
              }
              System.out.println("done");
            });
    t.start();
    Thread.sleep(500L);

    System.out.println("main");
    flag = false;
  }

  private static int count = 0;

  public static void test02() throws InterruptedException {
    int nThread = 9;
    CountDownLatch countDownLatch = new CountDownLatch(nThread);
    for (int i = 0; i < nThread; i++) {
      Thread t =
          new Thread(
              () -> {
                try {
                  count += 1;
                  System.out.println("count=" + count);
                  Thread.sleep(3000);
                  countDownLatch.countDown();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              });
      t.start();
    }

    // Thread.sleep(1000);
    countDownLatch.await();
    System.out.println(count);
  }

  public static void main(String[] args) throws InterruptedException {
    // test01();
    test02();
  }
}
