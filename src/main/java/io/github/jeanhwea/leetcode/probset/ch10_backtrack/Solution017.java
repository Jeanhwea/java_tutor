package io.github.jeanhwea.leetcode.probset.ch10_backtrack;

import java.util.*;

/**
 * 电话号码的字母组合
 *
 * @author Jinghui Hu
 * @since 2021-08-23, JDK1.8
 */
@SuppressWarnings("all")
public class Solution017 {

  private static String[] button =
      new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  private static List<String> ans;
  private static StringBuffer choose;
  private static String a;
  private static int n;

  private static void backtrack(int k) {
    if (k == n) {
      ans.add(new String(choose));
      return;
    }

    String letters = button[a.charAt(k) - '2'];
    for (int i = 0; i < letters.length(); i++) {
      choose.append(letters.charAt(i));
      backtrack(k + 1);
      choose.deleteCharAt(choose.length() - 1);
    }
  }

  public static List<String> letterCombinations(String digits) {
    a = digits;
    n = digits.length();
    ans = new LinkedList<>();
    choose = new StringBuffer();

    if (digits.length() <= 0) return ans;

    backtrack(0);
    return ans;
  }

  public static void main(String[] args) {
    // String digits = "23";
    String digits = "";
    System.out.println(letterCombinations(digits));
  }
}
