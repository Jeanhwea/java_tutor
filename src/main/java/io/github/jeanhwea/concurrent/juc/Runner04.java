package io.github.jeanhwea.concurrent.juc;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁 ReentrantLock, 单个线程可以多次 lock 而不产生死锁
 *
 * @author Jinghui Hu
 * @since 2021-06-22, JDK1.8
 */
public class Runner04 {

  private static ReentrantLock relock = new ReentrantLock();

  public static void main(String[] args) {
    System.out.println("=============== Start ===============");
    for (int i = 0; i < 9; i++) {
      Thread t =
          new Thread(
              () -> {
                try {
                  relock.lock();
                  relock.lock(); // 单线程连续 lock 不产生死锁
                  Thread.sleep(1000);
                  String name = Thread.currentThread().getName();
                  System.out.println(name + ": " + new Date());
                  relock.unlock();
                  relock.unlock();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              });
      t.start();
    }
    System.out.println("=============== Done ===============");
  }
}
