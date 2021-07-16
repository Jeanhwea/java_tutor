package io.github.jeanhwea.leetcode.probset.ch01_array;

import java.util.*;

/**
 * 三数之和
 *
 * @author Jinghui Hu
 * @since 2021-06-30, JDK1.8
 */
@SuppressWarnings("all")
public class Solution015 {

  public static List<List<Integer>> threeSum(int[] a) {
    List<List<Integer>> ans = new LinkedList<>();
    int n = a.length;
    if (n < 3) return ans;
    Arrays.sort(a);

    for (int i = 0; i < n - 1; i++) {
      if (i != 0 && a[i] == a[i - 1]) continue;

      int k = n - 1;
      for (int j = i + 1; j < n; j++) {
        if (j > i + 1 && a[j] == a[j - 1]) continue;

        while (k > j && a[k] + a[i] + a[j] > 0) k--;

        // System.out.printf("i,j,k=%d,%d,%d\n", i, j, k);
        if (k > j && a[i] + a[j] + a[k] == 0) {
          ans.add(Arrays.asList(a[i], a[j], a[k]));
        }
      }
    }
    return ans;
  }

  public static List<List<Integer>> threeSum0(int[] a) {
    int n = a.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) map.put(a[i], i);

    List<List<Integer>> ans = new LinkedList<>();
    Set<List<Integer>> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        Integer k = map.get(-a[i] - a[j]);
        if (k != null && k != i && k != j) {
          List<Integer> x = Arrays.asList(a[i], a[j], a[k]);
          Collections.sort(x);
          set.add(x);
        }
      }
    }

    return new ArrayList<>(set);
  }

  public static void main(String[] args) {
    // int[] a = {-1, 0, 1, 2, -1, -4};
    // int[] a = {0, 0, 0, 0};
    // int[] a = {0, 0, 0};
    int[] a = {-1, 0, 1, 0};
    System.out.println(threeSum(a));
  }
}
