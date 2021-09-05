package io.github.jeanhwea.leetcode.probset.ch01_array;

import java.util.*;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author Jinghui Hu
 * @since 2021-09-05, JDK1.8
 */
@SuppressWarnings("all")
public class Solution034 {

  // 二分查找, 找到元素后再搜索左右边界
  public static int[] searchRange(int[] nums, int target) {
    int beg = 0, end = nums.length - 1;
    while (beg <= end) {
      int mid = beg + (end - beg) / 2;
      if (nums[mid] == target) {
        int left = mid, right = mid;
        while (left > 0 && nums[left - 1] == target) left--;
        while (right < nums.length - 1 && nums[right + 1] == target) right++;
        return new int[] {left, right};
      } else if (nums[mid] < target) {
        beg = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return new int[] {-1, -1};
  }

  public static void main(String[] args) {
    int[] nums = {5, 7, 7, 8, 8, 10};
    int target = 6;
    int[] ans = searchRange(nums, target);
    System.out.println(Arrays.toString(ans));
  }
}
