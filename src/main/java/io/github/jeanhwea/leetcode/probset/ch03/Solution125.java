package io.github.jeanhwea.leetcode.probset.ch03;

import java.util.*;

/**
 * 验证回文串
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution125 {

  public static boolean isPalindrome(String s) {
    char[] a = s.toCharArray();
    int i = 0, j = a.length - 1;
    while (i < j) {
      if (!Character.isLetterOrDigit(a[i])) {
        i++;
        continue;
      }
      if (!Character.isLetterOrDigit(a[j])) {
        j--;
        continue;
      }
      if (Character.toLowerCase(a[i]) != Character.toLowerCase(a[j])) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "0P";
    System.out.println(isPalindrome(s));
  }
}
