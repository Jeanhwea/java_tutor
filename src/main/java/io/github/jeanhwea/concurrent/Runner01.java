package io.github.jeanhwea.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class Runner01 {

  ////////////////////////////////////////////////////////////////////////////////
  // 不加锁（不安全操作）
  public static Integer num1 = 0;

  public static void test01() {
    for (int i = 0; i < 10; i++) {
      Thread t =
          new Thread(
              () -> {
                while (num1 < 999) {
                  String threadName = Thread.currentThread().getName();
                  System.out.printf("%03d: %s\n", num1++, threadName);
                }
              });
      t.start();
    }
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 悲观锁
  public static Integer num2 = 0;

  public static void test02() {
    for (int i = 0; i < 10; i++) {
      Thread t =
          new Thread(
              () -> {
                synchronized (Runner01.class) {
                  while (num1 < 999) {
                    String threadName = Thread.currentThread().getName();
                    System.out.printf("%03d: %s\n", num1++, threadName);
                  }
                }
              });
      t.start();
    }
  }

  ////////////////////////////////////////////////////////////////////////////////
  // CAS 乐观锁
  public static AtomicInteger num3 = new AtomicInteger(0);

  public static void test03() {
    for (int i = 0; i < 10; i++) {
      Thread t =
          new Thread(
              () -> {
                while (num3.get() < 999) {
                  String threadName = Thread.currentThread().getName();
                  System.out.printf("%03d: %s\n", num3.getAndIncrement(), threadName);
                }
              });
      t.start();
    }
  }

  public static void main(String[] args) {
    test01();
    // test02();
    // test03();
  }
}
