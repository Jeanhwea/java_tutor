package io.github.jeanhwea.leetcode.basic.ch03;

import java.util.*;

/**
 * 最长公共前缀
 *
 * @author Jinghui Hu
 * @since 2021-06-10, JDK1.8
 */
public class Solution014 {

  public static String longestCommonPrefix(String[] strs) {
    int n = strs[0].length();

    for (int i = 0; i < n; i++) {
      char ch = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (i < strs[j].length() && strs[j].charAt(i) != ch) {
          return strs[0].substring(0, i);
        }
      }
    }

    return strs[0];
  }

  public static void main(String args[]) {
    String[] strs = {"flo", "flower", "flow", "fligtht"};
    System.out.println(Arrays.toString(strs));
    System.out.println("========================================");
    System.out.println(longestCommonPrefix(strs));
  }
}
