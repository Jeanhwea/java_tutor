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
    int n = a.length;
    List<List<Integer>> ans = new LinkedList<>();
    if (n < 4) return ans;

    Arrays.sort(a);

    for (int i = 0; i < n - 3; i++) {
      if (i != 0 && a[i] == a[i - 1]) continue;
      if (a[i] + a[i + 1] + a[i + 2] + a[i + 3] > target) break;

      for (int j = i + 1; j < n - 2; j++) {
        if (j != i + 1 && a[j] == a[j - 1]) continue;
        if (a[i] + a[j] + a[j + 1] + a[j + 2] > target) break;

        int y = n - 1;
        for (int x = j + 1; x < y; x++) {
          if (x != j + 1 && a[x] == a[x - 1]) continue;

          while (y > x && a[i] + a[j] + a[x] + a[y] > target) y--;
          if (y > x && a[i] + a[j] + a[x] + a[y] == target) {
            ans.add(Arrays.asList(a[i], a[j], a[x], a[y]));
          }
        }
      }
    }

    return ans;
  }

  public static List<List<Integer>> fourSum0(int[] a, int target) {
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
    int[] a = {2, 2, 2, 2, 2};
    // int[] a = {-3, -1, 0, 2, 4, 5};
    // int[] a = {-2, -1, -1, 1, 1, 2, 2};
    System.out.println(fourSum0(a, 8));
    System.out.println(fourSum(a, 8));
  }
}
