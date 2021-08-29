package io.github.jeanhwea.leetcode.basic.ch03_string;

/**
 * 验证回文串
 *
 * @author Jinghui Hu
 * @since 2021-06-09, JDK1.8
 */
@SuppressWarnings("all")
public class Solution125 {

  public static boolean isPalindrome(String s) {
    int n = s.length();
    int i = 0, j = n - 1;
    char ch1, ch2;
    while (i < j) {
      while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
      while (j > i && !Character.isLetterOrDigit(s.charAt(j))) j--;
      ch1 = Character.toLowerCase(s.charAt(i));
      ch2 = Character.toLowerCase(s.charAt(j));
      if (ch1 != ch2) return false;
      i++;
      j--;
    }
    return true;
  }

  public static boolean isPalindrome0(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isLetterOrDigit(ch)) {
        sb.append(Character.toLowerCase(ch));
      }
    }

    // System.out.println(sb);

    int n = sb.length();
    if (n <= 0) return true;

    int i = 0, j = n - 1;
    while (i < j) {
      if (sb.charAt(i) != sb.charAt(j)) return false;
      i++;
      j--;
    }

    return true;
  }

  public static void main(String[] args) {
    // String s = "A man, a plan, a canal; Panama";
    String s = "0P";
    System.out.println(isPalindrome(s));
  }
}
