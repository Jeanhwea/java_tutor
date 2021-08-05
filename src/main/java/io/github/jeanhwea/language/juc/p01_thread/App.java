package io.github.jeanhwea.language.juc.p01_thread;

/**
 * 线程
 *
 * @author Jinghui Hu
 * @since 2021-07-26, JDK1.8
 */
public class App {
  public static void main(String[] args) {
    Runnable runnable =
        new Runnable() {
          @Override
          public void run() {
            System.out.println(Thread.currentThread().getName());
          }
        };
    Thread thread = new Thread(runnable);
    thread.start();
  }
}
