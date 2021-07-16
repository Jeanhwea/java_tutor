package io.github.jeanhwea.leetcode.probset.ch01_array;

import java.util.*;

/**
 * 两数之和
 *
 * @author Jinghui Hu
 * @since 2021-06-30, JDK1.8
 */
@SuppressWarnings("all")
public class Solution001 {

  public static int[] twoSum(int[] a, int target) {
    int n = a.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      Integer j = map.get(a[i]);
      if (j != null) {
        return new int[] {j, i};
      } else {
        map.put(target - a[i], i);
      }
    }
    return null;
  }

  public static void main(String[] args) {
    int[] a = {2, 7, 11, 15};
    int[] res = twoSum(a, 9);
    System.out.println(Arrays.toString(res));
  }
}
