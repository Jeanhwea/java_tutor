package io.github.jeanhwea.language.jdk.p04_queue;

import java.util.*;

/**
 * 队列和双向队列
 *
 * @author Jinghui Hu
 * @since 2021-07-26, JDK1.8
 */
@SuppressWarnings("all")
public class App04 {

  public static void test01() {
    // 队列
    Queue<Integer> queue1 = new LinkedList<>();
    queue1.offer(7);
    queue1.poll();
    queue1.peek();
    queue1.isEmpty();

    // 双向队列 （和双向链表一样）
    Deque<Integer> deque1 = new LinkedList<>();
  }

  public static void main(String[] args) {
    test01();
  }
}
