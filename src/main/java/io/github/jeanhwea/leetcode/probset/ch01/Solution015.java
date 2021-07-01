package io.github.jeanhwea.leetcode.probset.ch01;

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
    int n = a.length;
    if (n < 3) return null;

    Arrays.sort(a);
    List<List<Integer>> ans = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      while (i > 0 && a[i] == a[i - 1]) i++;

      int target = -a[i];
      for (int j = n - 1; j >= 0; j--) {
        while (j < n - 1 && a[j] == a[j + 1]) j--;

        for (int k = i + 1; k < j; k++) {
          if (a[j] + a[k] == target) {
            ans.add(Arrays.asList(a[i], a[k], a[j]));
          }
        }
      }
    }

    return ans;
  }

  public static List<List<Integer>> threeSum0(int[] a) {
    int n = a.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) map.put(a[i], i);

    // List<List<Integer>> ans = new LinkedList<>();
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
    int[] a = {-1, 0, 1, 2, -1, -4};
    System.out.println(threeSum(a));
  }
}
