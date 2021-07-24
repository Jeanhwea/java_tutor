package io.github.jeanhwea.leetcode.basic.ch03_string;

/**
 * 外观数列
 *
 * @author Jinghui Hu
 * @since 2021-06-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution038 {

  // 暴露统计解法
  public static String countAndSay0(int k) {
    if (k <= 1) return "1";
    String p = countAndSay(k - 1), s = "";
    int n = p.length(), count = 0;
    for (int i = 0; i < n; i++) {
      char ch = p.charAt(i);
      if (i == n - 1) {
        s += String.valueOf(count + 1) + ch;
      } else {
        char peek = p.charAt(i + 1);
        if (ch == peek) {
          count++;
        } else {
          s += String.valueOf(count + 1) + ch;
          ch = peek;
          count = 0;
        }
      }
    }
    return s;
  }

  // 双指针解法
  public static String countAndSay(int k) {
    if (k <= 1) return "1";
    String s0 = "1";
    for (int i = 1; i < k; i++) {
      int n = s0.length();
      String s = "";
      int p = 0, q = 0;
      while (p < n) {
        while (p < n && s0.charAt(p) == s0.charAt(q)) p++;
        s += String.valueOf(p - q) + s0.charAt(q);
        q = p;
      }
      s0 = s;
    }
    return s0;
  }

  public static void main(String[] args) {
    // System.out.println(countAndSay(4));
    for (int i = 0; i < 10; i++) {
      System.out.println(countAndSay0(i));
      System.out.println(countAndSay(i));
      System.out.println("=======");
    }
  }
}
