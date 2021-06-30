package io.github.jeanhwea.concurrent;

import java.util.*;
import java.util.concurrent.*;

/**
 * 线程池 ExecutorService 接口和 ThreadPoolExecutor 实现类
 *
 * @author Jinghui Hu
 * @since 2021-06-23, JDK1.8
 */
public class Runner05 {

  private static int countThread = 20;
  private static ExecutorService executorService;

  public static void main(String[] args) {
    System.out.println("=============== START ===============");

    executorService =
        new ThreadPoolExecutor(
            countThread,
            countThread,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>());

    for (int i = 0; i < countThread; i++) {
      int waitSeconds = i;
      executorService.execute(
          () -> {
            try {
              String name = Thread.currentThread().getName();
              Thread.sleep(1000L * waitSeconds);
              System.out.printf("%s: %s\n", name, new Date());
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          });
    }

    executorService.shutdown();
    System.out.println("=============== END ===============");
  }
}
