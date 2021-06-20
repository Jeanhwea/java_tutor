package io.github.jeanhwea.cheatsheet;

import java.util.*;

/**
 * @author Jinghui Hu
 * @since 2021-06-20, JDK1.8
 */
public class BuiltIn {

  ////////////////////////////////////////////////////////////////////////////////
  // 数组
  ////////////////////////////////////////////////////////////////////////////////
  public static void arrayIntro() {
    // 定长数组
    int[] arr1 = new int[10]; // 定义数组
    int[] arr2 = {1, 2, 3, 4}; // 定义并初始化数组

    Arrays.fill(arr1, 1); // 填充数组的所有元素为 1

    // 数组复制
    int[] arr3 = Arrays.copyOf(arr2, arr2.length);
    int[] arr4 = Arrays.copyOfRange(arr2, 2, 3); // => [3]
    // System.out.println(Arrays.toString(arr4));

    // 变长数组
    ArrayList<Integer> vec1 = new ArrayList<Integer>();
    vec1.add(1); // 添加元素到数组最后
    vec1.add(3);
    vec1.get(0); // 获取第 0 个元素
    vec1.size(); // 数组的长度
    // System.out.println(vec1);
    vec1.add(0, 8); // 添加到数组的第 0 个元素
    // System.out.println(vec1);
    vec1.set(1, 4); // 修改数组的第 1 个元素
    // System.out.println(vec1);
    vec1.remove(1); // 删除第 1 个元素
    // System.out.println(vec1);
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 链表
  ////////////////////////////////////////////////////////////////////////////////
  public static void listIntro() {
    // 单链表
    Deque<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 3));
    Deque<Integer> list2 = new LinkedList<>(); // 初始化空的单链表
    list1.size(); // 链表大小
    list1.isEmpty(); // 是否为空
    list1.offerFirst(8); // 表头插入 1 个元素
    list1.pollFirst(); // 表头删除 1 个元素
    list1.peekFirst(); // 查看表头元素
    // System.out.println(list1);

    // 双向链表
    Deque<Integer> deque1 = new LinkedList<>();
    deque1.offerFirst(1); // 往表头插入 1 个元素
    deque1.offerLast(8); // 往表尾插入 1 个元素

    deque1.pollFirst(); // 删除表头的 1 个元素
    deque1.pollLast(); // 删除表尾的 1 个元素

    deque1.peekFirst(); // 查看表头的元素
    deque1.peekLast(); // 查看表尾的元素

    System.out.println(deque1);
  }

  public static void main(String[] args) {
    arrayIntro();
    listIntro();
  }
}
