package io.github.jeanhwea.leetcode.interview.ch10;

import java.util.*;

/**
 * 最大数
 *
 * @author Jinghui Hu
 * @since 2021-06-16, JDK1.8
 */
public class Solution179 {

  public static String largestNumber0(int[] a) {
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

    if (numsArr[0] == 0) return "0";
    StringBuilder ret = new StringBuilder();
    for (int num : numsArr) {
      ret.append(num);
    }
    return ret.toString();
  }

  public static String largestNumber(int[] a) {
    int n = a.length;
    Integer[] arr = new Integer[n];
    for (int i = 0; i < n; i++) arr[i] = a[i];
    // Arrays.sort(arr, Comparator.comparing(String::valueOf));
    Arrays.sort(
        arr,
        (x, y) -> {
          String s = "" + x + y, t = "" + y + x;
          return (int) (Long.parseLong(t) - Long.parseLong(s));
        });

    if (arr[0] == 0) return "0";
    String ans = "";
    for (int i = 0; i < n; i++) {
      ans += arr[i];
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] a = {3, 30, 34, 5, 9};
    System.out.println(largestNumber(a));
  }
}
