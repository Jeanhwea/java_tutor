package io.github.jeanhwea.leetcode.interview.ch03;

import java.util.*;

/**
 * 乘积最大子数组
 *
 * @author Jinghui Hu
 * @since 2021-06-15, JDK1.8
 */
public class Solution152 {

  // 暴露搜索
  public static int maxProduct0(int[] a) {
    int n = a.length, ans = a[0];
    for (int i = 0; i < n; i++) {
      int val = 1;
      for (int j = i; j < n; j++) {
        val *= a[j];
        if (val > ans) ans = val;
      }
    }
    return ans;
  }

  // 动态规划
  public static int maxProduct(int[] a) {
    int n = a.length;
    return 0;
  }

  public static void main(String args[]) {
    // int[] nums = {4, -9, -1, 2, 3, -1, 4};
    int[] nums = {0, 2};
    System.out.println(Arrays.toString(nums));
    System.out.println("========================================");
    System.out.println(maxProduct0(nums));
  }
}
