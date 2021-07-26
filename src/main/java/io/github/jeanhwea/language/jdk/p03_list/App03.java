package io.github.jeanhwea.language.jdk.p03_list;

import java.util.*;

/**
 * 链表
 *
 * @author Jinghui Hu
 * @since 2021-07-26, JDK1.8
 */
@SuppressWarnings("all")
public class App03 {

  public static void test01() {
    // 单链表
    Deque<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 3));
    Deque<Integer> list2 = new LinkedList<>(); // 初始化空的单链表
    list1.size(); // 链表大小
    list1.isEmpty(); // 是否为空
    list1.offerFirst(8); // 表头插入 1 个元素
    list1.pollFirst(); // 表头删除 1 个元素
    list1.peekFirst(); // 查看表头元素

    // 双向链表
    Deque<Integer> delist1 = new LinkedList<>(Arrays.asList(2, 3, 4));
    delist1.offerFirst(1); // 往表头插入 1 个元素
    delist1.offerLast(8); // 往表尾插入 1 个元素

    delist1.pollFirst(); // 删除表头的 1 个元素
    delist1.pollLast(); // 删除表尾的 1 个元素

    delist1.peekFirst(); // 查看表头的元素
    delist1.peekLast(); // 查看表尾的元素
  }

  public static void main(String[] args) {
    test01();
  }
}
