package io.github.jeanhwea.leetcode.probset.ch01;

import java.util.*;

/**
 * 四数之和
 *
 * @author Jinghui Hu
 * @since 2021-07-06, JDK1.8
 */
@SuppressWarnings("all")
public class Solution018 {

  public static List<List<Integer>> fourSum(int[] a, int target) {
    Arrays.sort(a);
    int n = a.length;

    Set<List<Integer>> ans = new HashSet<>();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int sum = target - a[i] - a[j];
        int y = n - 1;
        for (int x = j + 1; x < y; x++) {
          if (x != j + 1 && a[x] == a[x - 1]) continue;

          while (y > x && a[y] + a[x] > sum) y--;

          if (y > x && a[y] + a[x] == sum) {
            ans.add(Arrays.asList(a[i], a[j], a[x], a[y]));
          }
        }
      }
    }

    return new LinkedList<>(ans);
  }

  public static void main(String[] args) {
    // int[] a = {1, 0, -1, 0, -2, 2};
    // System.out.println(fourSum(a, 0));
    // int[] a = {2, 2, 2, 2, 2};
    // int[] a = {-3, -1, 0, 2, 4, 5};
    int[] a = {-2, -1, -1, 1, 1, 2, 2};
    System.out.println(fourSum(a, 0));
  }
}
