package io.github.jeanhwea.leetcode.basic;

import java.util.*;

public class Solution014 {

  public static String longestCommonPrefix(String[] strs) {
    StringBuilder sb = new StringBuilder();
    int n = strs[0].length();

    for (int i = 0; i < n; i++) {
      for (int j = 1; j < n&&j<strs[i].length(); j++) {
        if (strs[j].charAt(i) != strs[j].charAt(i)) {
          //
        }
      }
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
