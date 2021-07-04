package io.github.jeanhwea.lang.jvm;

import java.util.*;

/**
 * 逃逸分析
 *
 * @author Jinghui Hu
 * @since 2021-07-04, JDK1.8
 */
@SuppressWarnings("all")
public class Example02 {

  // -Xmx10m -Xms10m -XX:+PrintGC -XX:-DoEscapeAnalysis
  public static void main(String[] args) {
    while (true) {
      Integer temp = new Integer(99999999);
    }
  }
}
