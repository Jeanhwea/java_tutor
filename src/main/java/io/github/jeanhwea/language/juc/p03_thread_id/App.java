package io.github.jeanhwea.language.juc.p03_thread_id;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用原子类型和 ThreadLocal 实现唯一线程 ID
 *
 * @author Jinghui Hu
 * @since 2021-07-04, JDK1.8
 */
public class App {

  public static class ThreadId {

    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId =
        new ThreadLocal<Integer>() {
          @Override
          protected Integer initialValue() {
            return nextId.getAndIncrement();
          }
        };

    public static int get() {
      return threadId.get();
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      Thread t =
          new Thread(
              () -> {
                try {
                  int threadId = ThreadId.get();
                  Thread.sleep(500L);
                  System.out.printf("Thread(%d)\n", threadId);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              });
      t.start();
    }
  }
}
