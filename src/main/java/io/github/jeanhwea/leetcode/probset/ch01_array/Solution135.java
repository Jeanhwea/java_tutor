package io.github.jeanhwea.leetcode.probset.ch01_array;

import java.util.*;

/**
 * 分发糖果
 *
 * @author Jinghui Hu
 * @since 2021-07-08, JDK1.8
 */
@SuppressWarnings("all")
public class Solution135 {

  public static int candy(int[] a) {
    int n = a.length;
    int[] left = new int[n];
    Arrays.fill(left, 1);
    for (int i = 1; i < n; i++) {
      if (a[i] > a[i - 1]) {
        left[i] = left[i - 1] + 1;
      }
    }
    // System.out.println(Arrays.toString(left));
    int right = 1, ans = Math.max(left[n - 1], right);
    for (int i = n - 2; i >= 0; i--) {
      if (a[i] > a[i + 1]) {
        right++;
      } else {
        right = 1;
      }
      ans += Math.max(left[i], right);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] ratings = {1, 0, 2};
    System.out.println(candy(ratings));
  }
}
