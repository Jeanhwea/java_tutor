package io.github.jeanhwea.language.jdk.p02_array;

import java.util.*;

/**
 * 数组
 *
 * @author Jinghui Hu
 * @since 2021-07-26, JDK1.8
 */
@SuppressWarnings("all")
public class App02 {

  public static void test01() {
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
    vec1.add(4);
    vec1.get(0); // 获取第 0 个元素
    vec1.size(); // 数组的长度
    // System.out.println(vec1);
    vec1.add(0, 8); // 添加到数组的第 0 个元素
    // System.out.println(vec1);
    vec1.set(1, 4); // 修改数组的第 1 个元素
    // System.out.println(vec1);
    vec1.remove(1); // 删除第 1 个元素
    // System.out.println(vec1);

    List<Integer> vec2 = vec1.subList(0, 2); // 获取子链表的前 2 个元素
    // System.out.println(vec2);

    // 数组排序
    Arrays.sort(arr2);
  }

  @SuppressWarnings("unchecked")
  public static void test02() {
    // 声明 HashMap 数组
    Map<Character, Integer>[] mapArray = new HashMap[9];
    // 需要初始化元素
    for (int i = 0; i < 9; i++) mapArray[i] = new HashMap<>();
  }

  public static void test03() {
    // List 转 Array
    List<String> list = new ArrayList<>();
    String[] arr1 = new String[] {"a", "b", "c"};
    for (int i = 0; i < arr1.length; i++) {
      list.add(arr1[i]);
    }
    // System.out.println(list);

    // Array 转 List
    List<String> names =
        new LinkedList<String>() {
          {
            add("Jack");
            add("Tome");
          }
        };
    String[] arr2 = new String[names.size()];
    names.toArray(arr2);
    // System.out.println(Arrays.toString(arr2));
  }

  public static void test04() {
    int[][] grid = {
      {1, 1, 0, 1, 0},
      {1, 1, 0, 1, 1},
      {1, 1, 0, 0, 0},
      {0, 0, 0, 0, 0}
    };
    // n 总行数, m 总列数
    int n = grid.length, m = grid[0].length;

    // 打印上三角
    for (int i = 0; i < n; i++) {
      // x 当前行数, y 当前列数
      int x = i, y = m - 1;
      while (x >= 0 && y >= 0) {
        System.out.println(grid[x--][y--]);
      }
    }

    // 打印下三角 (去除对角线)
    for (int j = m - 2; j >= 0; j--) {
      int x = n - 1, y = j;
      while (x >= 0 && y >= 0) {
        System.out.println(grid[x--][y--]);
      }
    }
  }

  public static void main(String[] args) {
    test01();
    test02();
    test03();
    test04();
  }
}
