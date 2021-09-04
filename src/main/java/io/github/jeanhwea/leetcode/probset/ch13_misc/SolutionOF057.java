package io.github.jeanhwea.leetcode.probset.ch13_misc;

import java.util.*;

/**
 * 和为 s 的两个数字
 *
 * @author Jinghui Hu
 * @since 2021-09-04, JDK1.8
 */
@SuppressWarnings("all")
public class SolutionOF057 {

  public static int[] twoSum(int[] nums, int target) {
    int i = 0, j = nums.length - 1;
    while (i < j) {
      if (nums[i] + nums[j] == target) {
        return new int[] {nums[i], nums[j]};
      } else if (nums[i] + nums[j] < target) {
        i++; // 最小的加最大的都比 target 小，舍弃最小的
      } else {
        j--; // 最大的加最小的都比 target 大，舍弃最大的
      }
    }
    return new int[0];
  }

  public static int[] twoSum0(int[] nums, int target) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int goal = target - nums[i];
      int beg = i + 1, end = n - 1;
      while (beg <= end) {
        int mid = beg + (end - beg) / 2;
        if (nums[mid] == goal) {
          return new int[] {nums[i], nums[mid]};
        } else if (nums[mid] < goal) {
          beg = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    // pass
  }
}
