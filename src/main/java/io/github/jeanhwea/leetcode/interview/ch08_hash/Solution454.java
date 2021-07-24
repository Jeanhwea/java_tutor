package io.github.jeanhwea.leetcode.interview.ch08_hash;

import java.util.*;

/**
 * 四数相加 II
 *
 * @author Jinghui Hu
 * @since 2021-06-19, JDK1.8
 */
@SuppressWarnings("all")
public class Solution454 {

  public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    int n = nums1.length, count = 0;
    Map<Integer, Integer> tb = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int v = nums1[i] + nums2[j];
        tb.put(v, tb.getOrDefault(v, 0) + 1);
      }
    }

    for (int k = 0; k < n; k++) {
      for (int l = 0; l < n; l++) {
        int v = nums3[k] + nums4[l];
        count += tb.getOrDefault(-v, 0);
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[][] a = {
      {1, 2},
      {-2, -1},
      {-1, 2},
      {0, 2}
    };
    int ans = fourSumCount(a[0], a[1], a[2], a[3]);
    System.out.println(ans);
  }
}
