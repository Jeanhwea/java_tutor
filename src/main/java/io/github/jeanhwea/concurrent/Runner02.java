package io.github.jeanhwea.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * AQS 实现互斥锁 Mutex
 *
 * @author Jinghui Hu
 * @since 2021-06-22, JDK1.8
 */
public class Runner02 {

  static class Mutex implements Lock, java.io.Serializable {

    // 实现内部的帮助类
    private static class Sync extends AbstractQueuedSynchronizer {

      // 当前是否锁定
      protected boolean isHeldExclusively() {
        return getState() == 1;
      }

      // 获取互斥锁
      public boolean tryAcquire(int acquires) {
        assert acquires == 1; // Otherwise unused
        if (compareAndSetState(0, 1)) {
          setExclusiveOwnerThread(Thread.currentThread());
          return true;
        }
        return false;
      }

      // 释放互斥锁
      protected boolean tryRelease(int releases) {
        assert releases == 1; // Otherwise unused
        if (getState() == 0) throw new IllegalMonitorStateException();
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
      }

      // 返回条件
      Condition newCondition() {
        return new ConditionObject();
      }

      // Deserializes properly
      private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        setState(0); // reset to unlocked state
      }
    }

    private final Sync sync = new Sync();

    public void lock() {
      sync.acquire(1);
    }

    public boolean tryLock() {
      return sync.tryAcquire(1);
    }

    public void unlock() {
      sync.release(1);
    }

    public Condition newCondition() {
      return sync.newCondition();
    }

    public boolean isLocked() {
      return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads() {
      return sync.hasQueuedThreads();
    }

    public void lockInterruptibly() throws InterruptedException {
      sync.acquireInterruptibly(1);
    }

    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
      return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }
  }

  private static Mutex mutex = new Mutex();

  public static void main(String[] args) throws InterruptedException {
    System.out.println("=============== Start ===============");
    for (int i = 0; i < 9; i++) {
      Thread t =
          new Thread(
              () -> {
                try {
                  mutex.lock();
                  Thread.sleep(1000);
                  String name = Thread.currentThread().getName();
                  System.out.println(name + ": " + new Date());
                  mutex.unlock();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              });
      t.start();
    }
    System.out.println("=============== Done ===============");
  }
}
