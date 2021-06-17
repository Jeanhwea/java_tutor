package io.github.jeanhwea.leetcode.basic.ch08;

import java.util.*;

/**
 * 打乱数组
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution384 {

  private static Random rand = new Random();

  int[] nums0, nums;

  public Solution384(int[] nums) {
    this.nums0 = nums;
    this.nums = Arrays.copyOf(this.nums0, this.nums0.length);
  }

  public int[] reset() {
    this.nums = Arrays.copyOf(this.nums0, this.nums0.length);
    return this.nums;
  }

  private void swap(int i, int j) {
    int t = this.nums[i];
    this.nums[i] = this.nums[j];
    this.nums[j] = t;
  }

  public int[] shuffle() {
    for (int i = 0; i < this.nums.length; i++) {
      int k = i + rand.nextInt(this.nums.length - i);
      swap(i, k);
    }
    return this.nums;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6};
    Solution384 sol = new Solution384(a);
    System.out.println(Arrays.toString(sol.reset()));
    System.out.println(Arrays.toString(sol.shuffle()));
    System.out.println(Arrays.toString(sol.reset()));
    System.out.println(Arrays.toString(sol.shuffle()));
  }
}
