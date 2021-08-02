package io.github.jeanhwea.language.jdk.p13_lambda;

import java.util.*;

/**
 * Lambda 表达式和匿名内部类
 *
 * @author Jinghui Hu
 * @since 2021-08-02, JDK1.8
 */
@SuppressWarnings("all")
public class App13 {

  public static void main(String[] args) {
    // 匿名内部类写法
    Runnable run01 =
        new Runnable() {
          @Override
          public void run() {
            System.out.println("run01");
          }
        };

    // Lambda 表达式写法
    Runnable run02 =
        () -> {
          System.out.println("run02");
        };

    new Thread(run01).start();
    new Thread(run02).start();
  }
}
