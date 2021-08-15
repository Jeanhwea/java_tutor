package io.github.jeanhwea.leetcode.probset.ch07_greedy;

import java.util.*;

/**
 * 跳跃游戏
 *
 * @author Jinghui Hu
 * @since 2021-08-15, JDK1.8
 */
@SuppressWarnings("all")
public class Solution055 {

  // 贪心, 每次计算当前可以跳跃到最右边的值
  public static boolean canJump(int[] nums) {
    int n = nums.length;
    int rightMost = 0;
    for (int i = 0; i < n; i++) {
      if (i <= rightMost) {
        rightMost = Math.max(rightMost, i + nums[i]);
        if (rightMost >= n - 1) return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] a = new int[] {2, 3, 1, 1, 4};
    // int[] a = new int[] {3, 2, 1, 0, 4};
    System.out.println(canJump(a));
  }
}
