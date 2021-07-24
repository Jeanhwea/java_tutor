package io.github.jeanhwea.leetcode.basic.ch10_misc;

/**
 * 丢失的数字
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
@SuppressWarnings("all")
public class Solution268 {

  // 哈希表查找
  public static int misssingNumber0(int[] a) {
    int n = a.length;
    boolean[] tb = new boolean[n + 1];
    for (int i = 0; i < n; i++) tb[a[i]] = true;
    for (int i = 0; i <= n; i++) if (!tb[i]) return i;
    return -1;
  }

  // 异或运算：由于数字只出现一次，使用异或可以查找到丢失的数字
  public static int misssingNumber(int[] a) {
    int n = a.length;
    int missing = n;
    for (int i = 0; i < n; i++) {
      missing ^= i ^ a[i];
    }
    return missing;
  }

  public static void main(String[] args) {
    int[] a = {3, 1, 0};
    System.out.println(misssingNumber(a));
  }
}
