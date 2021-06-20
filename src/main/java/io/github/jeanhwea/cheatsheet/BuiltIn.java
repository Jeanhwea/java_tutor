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
    Deque<Integer> delist1 = new LinkedList<>(Arrays.asList(2, 3, 4));
    delist1.offerFirst(1); // 往表头插入 1 个元素
    delist1.offerLast(8); // 往表尾插入 1 个元素

    delist1.pollFirst(); // 删除表头的 1 个元素
    delist1.pollLast(); // 删除表尾的 1 个元素

    delist1.peekFirst(); // 查看表头的元素
    delist1.peekLast(); // 查看表尾的元素

    // System.out.println(delist1);
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 队列
  ////////////////////////////////////////////////////////////////////////////////
  public static void queueIntro() {
    // 队列
    Queue<Integer> queue1 = new LinkedList<>();
    queue1.offer(7);
    queue1.poll();
    queue1.peek();
    queue1.isEmpty();
    // System.out.println(queue1);

    // 双向队列 （和双向链表一样）
    Deque<Integer> deque1 = new LinkedList<>();
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 堆栈
  ////////////////////////////////////////////////////////////////////////////////
  public static void stackIntro() {
    // 栈
    Deque<Integer> stack1 = new LinkedList<>();
    stack1.push(2);
    stack1.push(3);
    stack1.pop();
    stack1.peek();
    stack1.isEmpty();
    // System.out.println(stack1.isEmpty());

    // 优先队列（堆）
    PriorityQueue<Integer> pq1 = new PriorityQueue<>(); // 新建一个小根堆
    PriorityQueue<Integer> pq2 = new PriorityQueue<>((x, y) -> y - x); // 新建一个大根堆
    pq1.offer(3); // 往堆添加 1 个元素
    pq1.poll(); // 删除堆中的元素
    pq1.peek(); // 查看堆顶的元素
    pq1.isEmpty();
    // System.out.println(pq1);
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 集合和列表
  ////////////////////////////////////////////////////////////////////////////////
  public static void setMapIntro() {
    // 集合
    Set<Integer> set1 = new HashSet<>();
    set1.add(3);
    set1.add(3);
    set1.add(4);
    set1.contains(4);
    // System.out.println(set1);

    // 散列表
    Map<String, Integer> map1 = new HashMap<>();
    map1.put("a", 3);
    map1.put("b", 4);
    map1.put("b", 8);
    map1.putIfAbsent("b", 8);
    map1.get("c"); // 查找 key, 如果不存在返回 null
    map1.getOrDefault("c", 0);
    // System.out.println(map1);

    map1.containsKey("s");
    map1.containsValue(8);

    map1.keySet(); // 键的集合
    map1.values(); // 值的集合
    map1.entrySet(); // 键值对的集合
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 字符串
  ////////////////////////////////////////////////////////////////////////////////
  public static void stringIntro() {
    // 字符串
    String str1 = "abcdef";
    str1.substring(0, 3); // => "abc"

    // 字符串分割和合并
    String str2 = "1,2,3,4";
    String[] res1 = str2.split(",");
    // System.out.println(Arrays.toString(res1));

    List<String> res2 = Arrays.asList(res1);
    // res2.add("xxx"); // => throw UnsupportedOperationException
    System.out.println(res2);
    List<String> res3 = new LinkedList<>(Arrays.asList(res1));
    res3.add("xxx"); // now is OK
    System.out.println(res3);

    String str3 = String.join(":", res3);
    System.out.println(str3);
  }

  public static void main(String[] args) {
    arrayIntro();
    listIntro();
    queueIntro();
    stackIntro();
    setMapIntro();
    stringIntro();
  }
}
