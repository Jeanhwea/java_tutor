package io.github.jeanhwea.leetcode.probset.ch03_string;

/**
 * 最长回文子串
 *
 * @author Jinghui Hu
 * @since 2021-07-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution005 {

  public static String longestPalindrome(String s) {
    char[] a = s.toCharArray();
    int n = a.length;
    int[][] valid = new int[n][n];

    int longest = 0;
    String ans = null;
    for (int len = 1; len <= n; len++) {
      for (int x = 0; x <= n - len; x++) {
        int y = x + len - 1;
        if (a[x] == a[y] && (len <= 2 || valid[x + 1][y - 1] == 1)) {
          valid[x][y] = 1;
          if (len > longest) {
            longest = len;
            ans = s.substring(x, y + 1);
          }
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("abababa"));
    System.out.println(longestPalindrome("cbbd"));
    // System.out.println(longestPalindrome("ac"));
  }
}
