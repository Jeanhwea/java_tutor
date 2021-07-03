package io.github.jeanhwea.lang.juc;

import java.util.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * AQS 实现 Latch
 *
 * @author Jinghui Hu
 * @since 2021-06-22, JDK1.8
 */
public class Runner03 {

  public static class BooleanLatch {

    private static class Sync extends AbstractQueuedSynchronizer {
      boolean isSignalled() {
        return getState() != 0;
      }

      protected int tryAcquireShared(int ignore) {
        return isSignalled() ? 1 : -1;
      }

      protected boolean tryReleaseShared(int ignore) {
        setState(1);
        return true;
      }
    }

    private final Sync sync = new Sync();

    public boolean isSignalled() {
      return sync.isSignalled();
    }

    public void signal() {
      sync.releaseShared(1);
    }

    public void await() throws InterruptedException {
      sync.acquireSharedInterruptibly(1);
    }
  }

  private static BooleanLatch latch = new BooleanLatch();

  public static void main(String[] args) throws InterruptedException {
    System.out.println(new Date());
    for (int i = 0; i < 9; i++) {
      Thread t =
          new Thread(
              () -> {
                try {
                  latch.await();
                  Thread.sleep(1000);
                  String name = Thread.currentThread().getName();
                  System.out.println(name + ": " + new Date());
                  latch.signal();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              });
      t.start();
    }
    Thread.sleep(3000);
    latch.signal();
    System.out.println(new Date());
  }
}
