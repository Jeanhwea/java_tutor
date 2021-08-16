package io.github.jeanhwea.leetcode.probset.ch07_greedy;

import java.util.*;

/**
 * 盛最多水的容器
 *
 * @author Jinghui Hu
 * @since 2021-08-15, JDK1.8
 */
@SuppressWarnings("all")
public class Solution011 {

  // 双指针+贪心算法
  public static int maxArea(int[] height) {
    int n = height.length, i = 0, j = n - 1, ans = 0;
    while (i < j) {
      ans = Math.max(ans, Math.min(height[j], height[i]) * (j - i));
      // 每次移动较小的高度才有可能获得较大的容量
      if (height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] a = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(maxArea(a));
  }
}
