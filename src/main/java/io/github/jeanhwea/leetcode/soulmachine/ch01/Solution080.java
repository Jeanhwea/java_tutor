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
    int n = a.length, k = -1, offset = 2;
    for (int i = 0; i < n; i++) {
        if (k<offset) {
          k++;
          continue;
        }
        if(a[i]!=a[k-offset]) {
          a[k++] = a[i];
        }
    }

    return k ;
  }

  public static void main(String[] args) {
    int[] a = {1, 1, 1, 2, 2, 3};
    int k = removeDuplicates(a);
    int[] b = Arrays.copyOfRange(a, 0, k);
    System.out.println(Arrays.toString(b));
  }
}
