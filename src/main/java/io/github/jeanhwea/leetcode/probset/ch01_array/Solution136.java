package io.github.jeanhwea.leetcode.probset.ch01_array;

/**
 * 只出现一次的数字
 *
 * @author Jinghui Hu
 * @since 2021-07-07, JDK1.8
 */
@SuppressWarnings("all")
public class Solution136 {

  public static int singleNumber(int[] a) {
    int ans = 0;
    for (int i = 0; i < a.length; i++) {
      ans ^= a[i];
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] a = {1, 3, 3, 2, 1};
    System.out.println(singleNumber(a));
  }
}
