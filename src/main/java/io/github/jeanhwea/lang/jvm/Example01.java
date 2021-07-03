package io.github.jeanhwea.lang.jvm;

import java.util.*;

/**
 * 线程栈
 *
 * @author Jinghui Hu
 * @since 2021-07-03, JDK1.8
 */
@SuppressWarnings("all")
public class Example01 {

  private static final int FINAL_VAR01 = 2;
  private String name = "hello";

  public int method01() {
    int a = 1;
    int b = 2;
    int c = (a + b) / 5;
    return c;
  }

  public static void main(String[] args) {
    Example01 example = new Example01();
    example.method01();
  }
}
