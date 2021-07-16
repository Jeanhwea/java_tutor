package io.github.jeanhwea.leetcode.probset.ch01_array;

import java.util.*;

/**
 * 移除元素
 *
 * @author Jinghui Hu
 * @since 2021-07-07, JDK1.8
 */
@SuppressWarnings("all")
public class Solution027 {

  public static int removeElement(int[] a, int val) {
    int n = a.length, k = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] != val) a[k++] = a[i];
    }
    return k;
  }

  public static void main(String[] args) {
    int[] a = {3, 2, 3, 2, 3};
    int n = removeElement(a, 3);
    System.out.println(Arrays.toString(Arrays.copyOfRange(a, 0, n)));
  }
}
