package io.github.jeanhwea.language.jdk.p05_stack_heap;

import java.util.*;

/**
 * 堆和栈
 *
 * @author Jinghui Hu
 * @since 2021-07-26, JDK1.8
 */
@SuppressWarnings("all")
public class App {

  public static void test01() {
    // 栈
    Deque<Integer> stack1 = new LinkedList<>();
    stack1.push(2);
    stack1.push(3);
    stack1.pop();
    stack1.peek();
    stack1.isEmpty();

    // 优先队列（堆）
    PriorityQueue<Integer> pq1 = new PriorityQueue<>(); // 新建一个小根堆
    PriorityQueue<Integer> pq2 = new PriorityQueue<>((x, y) -> y - x); // 新建一个大根堆
    pq1.offer(3); // 往堆添加 1 个元素
    pq1.poll(); // 删除堆中的元素
    pq1.peek(); // 查看堆顶的元素
    pq1.isEmpty();
  }

  public static void main(String[] args) {
    test01();
  }
}
