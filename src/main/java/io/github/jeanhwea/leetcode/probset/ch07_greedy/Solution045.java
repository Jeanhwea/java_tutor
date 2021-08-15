package io.github.jeanhwea.leetcode.probset.ch07_greedy;

import java.util.*;

/**
 * 跳跃游戏 II
 *
 * @author Jinghui Hu
 * @since 2021-08-15, JDK1.8
 */
@SuppressWarnings("all")
public class Solution045 {

  public static int jump(int[] nums) {
    int n = nums.length, rightMost = 0, prevRightMost = 0, steps = 0;
    for (int i = 0; i < n - 1; i++) {
      rightMost = Math.max(rightMost, i + nums[i]);
      if (i == prevRightMost) {
        prevRightMost = rightMost;
        steps++;
      }
    }
    return steps;
  }

  public static void main(String[] args) {
    int[] a = new int[] {2, 3, 1, 1, 4};
    // int[] a = new int[] {3, 2, 0, 1, 4};
    System.out.println(jump(a));
  }
}
