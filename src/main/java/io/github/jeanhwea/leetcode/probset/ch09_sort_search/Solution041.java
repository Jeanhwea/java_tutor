package io.github.jeanhwea.leetcode.probset.ch09_sort_search;

import java.util.*;

/**
 * 缺失的第一个正数
 *
 * @author Jinghui Hu
 * @since 2021-08-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution041 {

  // 原地哈希法
  public static int firstMissingPositive(int[] nums) {
    int n = nums.length;

    // Step 1: 将负数改成 n+1
    for (int i = 0; i < n; i++) {
      if (nums[i] <= 0) nums[i] = n + 1;
    }

    // Step 2: 将数组中小于 n 对应的位置改成负数
    for (int i = 0; i < n; i++) {
      int key = Math.abs(nums[i]);
      if (key <= n) {
        // 这里同一个数字可能出现多次, 需要始终保持 nums[key-1] 为负数
        nums[key - 1] = -Math.abs(nums[key - 1]);
      }
    }

    // Step 3: 从数组中查询第一个非负数
    for (int i = 0; i < n; i++) {
      if (nums[i] > 0) return i + 1;
    }

    return n + 1; // 如果没找到返回 n + 1
  }

  public static void main(String[] args) {
    // int[] a = new int[] {3, 4, -1, 1};
    int[] a = new int[] {1, 1};
    System.out.println(firstMissingPositive(a));
  }
}
