package io.github.jeanhwea.lang.juc;

public class Runner06 {

  // 这里如果不添加 volatile 关键字子线程只能读到 flag 为 true
  private static /* volatile */ boolean flag = true;

  public static void main(String[] args) throws InterruptedException {
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
}
