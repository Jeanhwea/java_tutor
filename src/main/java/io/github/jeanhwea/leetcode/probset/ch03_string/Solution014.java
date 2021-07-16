package io.github.jeanhwea.leetcode.probset.ch03_string;

/**
 * 最长公共前缀
 *
 * @author Jinghui Hu
 * @since 2021-07-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution014 {

  public static String longestCommonPrefix(String[] strs) {
    int n = strs.length, m = strs[0].length(), k = 0;

    done:
    for (int i = 0; i < m; i++) {
      char ch = strs[0].charAt(i);
      for (int j = 1; j < n; j++) {
        if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
          break done;
        }
      }
      k++;
    }

    return strs[0].substring(0, k);
  }

  public static void main(String[] args) {
    String[] strs = new String[] {"flower", "flower", "flower", "flower"};
    System.out.println(longestCommonPrefix(strs));
  }
}
