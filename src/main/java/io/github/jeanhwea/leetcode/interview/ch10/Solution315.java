package io.github.jeanhwea.leetcode.interview.ch10;

import java.util.*;

/**
 * 计算右侧小于当前元素的个数
 *
 * @author Jinghui Hu
 * @since 2021-06-20, JDK1.8
 */
public class Solution315 {

  private static int[] c;
  private static int[] a;

  // 树形数组
  public static List<Integer> countSmaller(int[] nums) {
    List<Integer> resultList = new ArrayList<>();

    // 离散化数据
    Set<Integer> set = new HashSet<>();
    for (int num : nums) set.add(num);

    int size = set.size();
    a = new int[size];
    int index = 0;
    for (int num : set) a[index++] = num;
    Arrays.sort(a);

    // 初始化树状数组
    c = new int[nums.length + 5];
    Arrays.fill(c, 0);

    for (int i = nums.length - 1; i >= 0; --i) {
      int id = getId(nums[i]);
      resultList.add(ask(id - 1));
      add(id);
    }
    Collections.reverse(resultList);
    return resultList;
  }

  // parent(t[x]) -> t[x+lowBit(x)]
  private static int lowbit(int x) {
    return x & (-x);
  }

  private static int getId(int x) {
    return Arrays.binarySearch(a, x) + 1;
  }

  private static void add(int pos) {
    while (pos < c.length) {
      c[pos] += 1;
      pos += lowbit(pos);
    }
  }

  private static int ask(int pos) {
    int ret = 0;
    while (pos > 0) {
      ret += c[pos];
      pos -= lowbit(pos);
    }
    return ret;
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
