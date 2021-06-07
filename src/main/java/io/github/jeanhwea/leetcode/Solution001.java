package io.github.jeanhwea.leetcode;

import java.util.*;

public class Solution001 {

  public static int[] twoSum(int[] a, int sum) {
    Map<Integer, Integer> lookup = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      if (lookup.containsKey(a[i])) {
        return new int[] {lookup.get(a[i]), i};
      }
      lookup.put(sum - a[i], i);
    }
    return null;
  }

  public static void main(String args[]) {
    int[] a = {2, 3, 5, 9};
    int n = 11;
    System.out.println(Arrays.toString(a));
    System.out.println(n);
    System.out.println("========================================");
    System.out.println(Arrays.toString(twoSum(a, n)));
  }
}
