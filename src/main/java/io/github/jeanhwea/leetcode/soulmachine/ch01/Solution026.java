package io.github.jeanhwea.leetcode.soulmachine.ch01;

import java.util.*;

/**
 * 删除有序数组中的重复项
 *
 * @author Jinghui Hu
 * @since 2021-06-28, JDK1.8
 */
public class Solution026 {

  public static int removeDuplicates(int[] a) {
    int n = a.length, k = -1;
    for (int i = 0; i < n; i++) {
      if (k < 0) {
        k++;
        continue;
      }
      if (a[i] != a[k]) a[++k] = a[i];
    }
    return k + 1;
  }

  public static void main(String[] args) {
    // int[] a = {1, 2, 2, 3};
    int[] a = {1, 1, 1, 1};
    // int[] a = {};
    int k = removeDuplicates(a);
    int[] b = Arrays.copyOfRange(a, 0, k);
    System.out.println(Arrays.toString(b));
  }
}
