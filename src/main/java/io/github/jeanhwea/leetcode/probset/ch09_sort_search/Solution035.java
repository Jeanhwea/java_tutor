package io.github.jeanhwea.leetcode.probset.ch09_sort_search;

import java.util.*;

/**
 * 搜索插入位置
 *
 * @author Jinghui Hu
 * @since 2021-08-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution035 {

  // 二分查找, 每次保证 target 在 [beg, end) 区间中
  public static int searchInsert(int[] nums, int target) {
    int beg = 0, end = nums.length;
    while (beg < end) {
      int mid = beg + (end - beg) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        beg = mid + 1;
      } else {
        end = mid;
      }
    }
    return beg;
  }

  public static void main(String[] args) {
    int[] a = new int[] {1, 3, 5, 6};
    System.out.println(searchInsert(a, 6));
  }
}
