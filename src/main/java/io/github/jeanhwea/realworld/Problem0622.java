package io.github.jeanhwea.realworld;

import java.util.*;

/**
 * 三数之和符合一个数值
 *
 * @author Jinghui Hu
 * @since 2021-07-01, JDK1.8
 */
@SuppressWarnings("all")
public class Problem0622 {

  public static List<List<Integer>> threeSum(int[] a, int target) {
    List<List<Integer>> ans = new LinkedList<>();
    int n = a.length;
    if (n < 3) return ans;

    Arrays.sort(a);

    for (int i = 0; i < n; i++) {
      while (i > 0 && a[i] == a[i - 1]) i++;

      int k = n - 1;
      for (int j = i + 1; j < k; j++) {
        while (j > i + 1 && a[j] == a[j - 1]) j++;

        while (k > j && a[i] + a[j] + a[k] > target) k--;

        if (k > j && a[i] + a[j] + a[k] == target) {
          ans.add(Arrays.asList(a[i], a[j], a[k]));
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] a = {1, 3, 4, 3, 8, 9, 10, 23, 0, 2};
    int target = 10;
    System.out.println(threeSum(a, target));
  }
}
