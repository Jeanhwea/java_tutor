package io.github.jeanhwea.leetcode.probset.ch12_dnc;

import java.util.*;

/**
 * 多数元素
 *
 * @author Jinghui Hu
 * @since 2021-07-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution169 {

  ////////////////////////////////////////////////////////////////////////////////
  // 选举法
  public static int majorityElement1(int[] a) {
    int n = a.length, candiate = 0, count = 0;
    // Step1: 预选, 选出候选人
    for (int i = 0; i < n; i++) {
      if (count <= 0) {
        candiate = a[i];
        count++;
        continue;
      }
      count += a[i] == candiate ? 1 : -1;
    }
    // Step2: 复验, 确保选举出的人确实是占用多数选票的
    count = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == candiate) count++;
      if (count > n / 2) return candiate;
    }
    return -1;
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 分治法
  public static int majorityElement(int[] a) {
    return merge(a, 0, a.length - 1);
  }

  // 合并 [beg, end] 区间的多数元素
  private static int merge(int[] a, int beg, int end) {
    if (beg == end) return a[beg];

    int mid = beg + (end - beg) / 2;
    int left = merge(a, beg, mid);
    int right = merge(a, mid + 1, end);

    if (left == right) return left;
    int countLeft = countInRange(a, beg, mid, left);
    int countRight = countInRange(a, mid + 1, end, right);
    return countLeft > countRight ? left : right;
  }

  // 计算 [beg, end] 区间中 target 出现的次数
  private static int countInRange(int[] a, int beg, int end, int target) {
    int count = 0;
    for (int i = beg; i <= end; i++) {
      if (a[i] == target) count++;
    }
    return count;
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 统计法, 使用哈希表统计
  public static int majorityElement0(int[] a) {
    int n = a.length;
    Map<Integer, Integer> count = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int c = count.getOrDefault(a[i], 0) + 1;
      if (c + c >= n) return a[i];
      count.put(a[i], c);
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] a1 = {1, 2, 3, 4, 2, 2, 2};
    System.out.println(majorityElement(a1));
  }
}
