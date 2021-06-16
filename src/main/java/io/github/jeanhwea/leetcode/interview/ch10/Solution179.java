package io.github.jeanhwea.leetcode.interview.ch10;

import java.util.*;

/**
 * 最大数
 *
 * @author Jinghui Hu
 * @since 2021-06-16, JDK1.8
 */
public class Solution179 {

  public static String largestNumber(int[] a) {
    int n = a.length;

    Integer[] numsArr = new Integer[n];
    for (int i = 0; i < n; i++) {
      numsArr[i] = a[i];
    }

    Arrays.sort(
        numsArr,
        (x, y) -> {
          long sx = 10, sy = 10;
          while (sx <= x) sx *= 10;
          while (sy <= y) sy *= 10;
          return (int) ((sx * y + x) - (sy * x + y));
        });

    if (numsArr[0] == 0) {
      return "0";
    }
    StringBuilder ret = new StringBuilder();
    for (int num : numsArr) {
      ret.append(num);
    }
    return ret.toString();
  }

  public static void main(String args[]) {
    int[] a = {2, 12, 9, 0};
    System.out.println(largestNumber(a));
  }
}
