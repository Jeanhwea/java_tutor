package io.github.jeanhwea.leetcode.interview.ch10;

import java.util.*;

/**
 * 计算右侧小于当前元素的个数
 *
 * @author Jinghui Hu
 * @since 2021-06-20, JDK1.8
 */
@SuppressWarnings("all")
public class Solution315 {

  private static int[] b, c;

  // 树状数组
  public static List<Integer> countSmaller(int[] a) {
    List<Integer> resultList = new ArrayList<>();

    // 离散化数据
    Set<Integer> set = new HashSet<>();
    for (int e : a) set.add(e);
    b = new int[set.size()];
    int k = 0;
    for (int e : set) b[k++] = e;
    Arrays.sort(b);

    // 初始化树状数组
    c = new int[a.length + 5];
    Arrays.fill(c, 0);

    for (int i = a.length - 1; i >= 0; --i) {
      int id = getId(a[i]);
      resultList.add(query(id - 1));
      update(id);
    }
    Collections.reverse(resultList);
    return resultList;
  }

  private static int lowbit(int x) {
    return x & (-x);
  }

  private static int getId(int x) {
    return Arrays.binarySearch(b, x) + 1;
  }

  private static void update(int pos) {
    while (pos < c.length) {
      c[pos] += 1;
      pos += lowbit(pos);
    }
  }

  private static int query(int pos) {
    int count = 0;
    while (pos > 0) {
      count += c[pos];
      pos -= lowbit(pos);
    }
    return count;
  }

  // 暴力统计法
  public static List<Integer> countSmaller0(int[] a) {
    int n = a.length;
    List<Integer> counts = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      int k = 0;
      for (int j = i + 1; j < n; j++) {
        if (a[j] < a[i]) k++;
      }
      counts.add(k);
    }
    return counts;
  }

  public static void main(String[] args) {
    int[] a = {5, 2, 6, 1};
    List<Integer> counts = countSmaller(a);
    System.out.println(counts);
  }
}
