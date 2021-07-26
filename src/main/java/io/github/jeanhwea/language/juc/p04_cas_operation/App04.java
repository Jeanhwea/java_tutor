package io.github.jeanhwea.language.juc.p04_cas_operation;

import java.util.concurrent.atomic.AtomicInteger;

public class App04 {

  private static final int numThread = 5;
  private static final int threshold = 99;

  private static void printNum(int num) {
    String threadName = Thread.currentThread().getName();
    System.out.printf("%s: %2d\n", threadName, num);
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 不加锁（不安全操作）
  public static Integer num1 = 0;

  public static void test01() {
    for (int i = 0; i < numThread; i++) {
      Thread t =
          new Thread(
              () -> {
                while (num1 < threshold) printNum(num1++);
              });
      t.start();
    }
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 悲观锁
  public static Integer num2 = 0;

  public static void test02() {
    for (int i = 0; i < numThread; i++) {
      Thread t =
          new Thread(
              () -> {
                synchronized (App04.class) {
                  while (num2 < threshold) printNum(num2++);
                }
              });
      t.start();
    }
  }

  ////////////////////////////////////////////////////////////////////////////////
  // CAS 乐观锁
  public static AtomicInteger num3 = new AtomicInteger(0);

  public static void test03() {
    for (int i = 0; i < numThread; i++) {
      Thread t =
          new Thread(
              () -> {
                while (num3.get() < threshold) printNum(num3.getAndIncrement());
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
