package io.github.jeanhwea.lang.jvm.p02_escape_analysis;

import java.util.*;

/**
 * 逃逸分析
 *
 * @author Jinghui Hu
 * @since 2021-07-04, JDK1.8
 */
@SuppressWarnings("all")
public class App02 {

  // -Xmx10m -Xms10m -XX:+PrintGC -XX:-DoEscapeAnalysis
  public static void main(String[] args) throws InterruptedException {
    while (true) {
      Integer temp = new Integer(99999999);
      Thread.sleep(100);
    }
  }
}
