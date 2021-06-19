package io.github.jeanhwea.leetcode.soulmachine.ch02;

import java.util.*;

/**
 * 删除有序数组中的重复项 II
 *
 * @author Jinghui Hu
 * @since 2021-06-20, JDK1.8
 */
public class Solution080 {

  public static int removeDuplicates(int[] a) {
    int n = a.length, k = 0, count = 0;
    for (int i = 0; i < n; i++) {
      if (k > 0 && a[i] == a[k - 1]) {
        if (count < 2) a[k++] = a[i];
        count++;
      } else {
        a[k++] = a[i];
        count = 1;
      }
    }

    return k;
  }

  public static void main(String[] args) {
    int[] a = {1, 1, 1, 2, 2, 2, 2, 3, 4};
    System.out.println(removeDuplicates(a));
    System.out.println(Arrays.toString(a));
  }
}
