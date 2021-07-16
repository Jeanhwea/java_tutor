package io.github.jeanhwea.leetcode.probset.ch01_array;

import java.util.*;

/**
 * 排列序列
 *
 * @author Jinghui Hu
 * @since 2021-07-06, JDK1.8
 */
@SuppressWarnings("all")
public class Solution060 {

  /**
   * 康托编码
   *
   * @author Jinghui Hu
   * @since 2021-07-06, JDK1.8
   */
  public static String getPermutation(int n, int k) {
    int[] fact = new int[n];
    fact[0] = 1;
    for (int i = 1; i < n; i++) {
      fact[i] = i * fact[i - 1];
    }

    int[] seen = new int[n + 1];
    Arrays.fill(seen, 0);
    --k;
    StringBuilder sb = new StringBuilder();
    while (true) {
      int groupLength = fact[n - sb.length() - 1];
      int count = k / groupLength;
      for (int i = 1; i <= n; i++) {
        if (seen[i] == 0) count--;
        if (count < 0) {
          seen[i] = 1;
          sb.append(i);
          break;
        }
      }
      k -= groupLength * (k / groupLength);

      if (sb.length() == n) break;
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    int n = 3, k = 3;
    System.out.println(getPermutation(n, k));
  }
}
