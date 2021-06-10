package io.github.jeanhwea.leetcode.basic;

import java.util.*;

public class Solution014 {

  public static String longestCommonPrefix(String[] strs) {
    StringBuilder sb = new StringBuilder();
    int n = strs[0].length();

    for (int i = 0; i < n; i++) {
      boolean same = true;
      char ch1 = strs[0].charAt(i);
      for (int j = 1; j < n; j++) {
        char ch2 = strs[j].charAt(i);
        if (ch1 != ch2 || i < strs[j].length()) {
          same = false;
          break;
        }
      }
      if (same) sb.append(ch1);
    }

    return sb.toString();
  }

  public static void main(String args[]) {
    String[] strs = {"flower", "flow", "fligtht"};
    System.out.println(Arrays.toString(strs));
    System.out.println("========================================");
    System.out.println(longestCommonPrefix(strs));
  }
}
