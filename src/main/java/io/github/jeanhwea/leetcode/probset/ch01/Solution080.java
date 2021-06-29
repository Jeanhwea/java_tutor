package io.github.jeanhwea.leetcode.probset.ch01;

import java.util.*;

/**
 * 删除有序数组中的重复项 II
 *
 * @author Jinghui Hu
 * @since 2021-06-20, JDK1.8
 */
public class Solution080 {

  public static int removeDuplicates(int[] a) {
    int n = a.length, offset = 2;

    if (n <= offset) return n;

    int k = offset;
    for (int i = offset; i < n; i++) {
      if (a[i] != a[k - offset]) {
        a[k++] = a[i];
      }
    }

    return k;
  }

  public static void main(String[] args) {
    int[] a = {1, 1, 1, 2, 2, 3};
    int k = removeDuplicates(a);
    int[] b = Arrays.copyOfRange(a, 0, k);
    System.out.println(Arrays.toString(b));
  }
}
