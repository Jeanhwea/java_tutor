package io.github.jeanhwea.realworld;

import java.util.*;

/**
 * 合并两个有序数组
 *
 * @author Jinghui Hu
 * @since 2021-08-11, JDK1.8
 */
@SuppressWarnings("all")
public class Problem0811 {

  public static void main(String[] args) {
    int[] a = {1, 4, 6, 8}, b = {2, 3, 4, 7, 22};
    int[] c = merge(a, b);
    System.out.println(Arrays.toString(c));
  }

  private static int[] merge(int[] a, int[] b) {
    int lenA = a.length, lenB = b.length;
    int[] c = new int[lenA + lenB];

    int i = 0, j = 0, k = 0;
    while (i < lenA && j < lenB) {
      c[k++] = a[i] < b[j] ? a[i++] : b[j++];
    }
    while (i < lenA) c[k++] = a[i++];
    while (j < lenB) c[k++] = b[j++];

    return c;
  }
}
