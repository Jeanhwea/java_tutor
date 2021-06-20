package io.github.jeanhwea.leetcode.interview.ch10;

import java.util.*;

/**
 * 计算右侧小于当前元素的个数
 *
 * @author Jinghui Hu
 * @since 2021-06-20, JDK1.8
 */
public class Solution315 {

  // TODO: 高效的算法
  public static List<Integer> countSmaller(int[] a) {
    return null;
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
