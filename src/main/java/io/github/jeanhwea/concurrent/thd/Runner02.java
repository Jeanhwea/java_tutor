package io.github.jeanhwea.concurrent.thd;

import java.util.concurrent.atomic.AtomicInteger;

public class Runner02 {

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
