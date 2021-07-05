package io.github.jeanhwea.leetcode.probset.ch01;

import java.util.*;

/**
 * 最接近的三数之和
 *
 * @author Jinghui Hu
 * @since 2021-07-05, JDK1.8
 */
@SuppressWarnings("all")
public class Solution016 {

  private static Integer ans;
  private static int currSum;
  private static List<Integer> choose;

  public static int threeSumClosest0(int[] a, int target) {
    ans = null;
    currSum = 0;
    choose = new ArrayList<>();
    dfs(a, 0, target);
    return ans;
  }

  public static void dfs(int[] a, int start, int target) {
    int n = a.length;
    if (choose.size() == 3) {
      if (ans == null || Math.abs(currSum - target) < Math.abs(ans - target)) {
        ans = currSum;
      }
      return;
    }
    if (start == n) return;

    dfs(a, start + 1, target);

    choose.add(a[start]);
    currSum += a[start];
    dfs(a, start + 1, target);
    choose.remove(choose.size() - 1);
    currSum -= a[start];
  }

  public static int threeSumClosest(int[] a, int target) {
    int n = a.length;
    Arrays.sort(a);

    int ans = a[0] + a[1] + a[2];
    for (int i = 0; i < n; i++) {
      if (i != 0 && a[i] == a[i - 1]) continue;

      int k = n - 1;
      for (int j = i + 1; j < k; j++) {
        if (j != i + 1 && a[j] == a[j - 1]) continue;

        // System.out.printf("i,j,k=%d,%d,%d\n", i, j, k);
        while (k > j) {
          int p = a[k] + a[i] + a[j];
          ans = Math.abs(ans - target) < Math.abs(p - target) ? ans : p;
          if (p < target) break;
          k--;
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] a = {-1, 2, 1, -4};
    int target = 1;
    // int[] a = {0, 0, 0};
    // int target = 1;
    // int[] a = {-1, 0, 1, 1, 55};
    // int target = 3;
    System.out.println(threeSumClosest(a, target));
  }
}
