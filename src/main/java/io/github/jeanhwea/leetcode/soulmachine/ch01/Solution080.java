package io.github.jeanhwea.leetcode.soulmachine.ch01;

import java.util.*;

/**
 * 删除有序数组中的重复项 II
 *
 * @author Jinghui Hu
 * @since 2021-06-20, JDK1.8
 */
public class Solution080 {

  public static int removeDuplicates(int[] a) {
    int n = a.length, k = -1, count = 0;
    for (int i = 0; i < n; i++) {
      if (k < 0) {
        count++;
        k++;
      } else {
        if (a[i] != a[k]) {
          a[++k] = a[i];
        } else {
          if (count > 1) {
            a[++k] = a[i];
            count = 0;
          }
          ++count;
        }
      }
    }

    return k + 1;
  }

  public static void main(String[] args) {
    int[] a = {1, 1, 1, 2, 2, 3};
    int k = removeDuplicates(a);
    int[] b = Arrays.copyOfRange(a, 0, k);
    System.out.println(Arrays.toString(b));
  }
}
