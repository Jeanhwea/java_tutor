package io.github.jeanhwea.leetcode.probset.ch03_string;

/**
 * 最后一个单词的长度
 *
 * @author Jinghui Hu
 * @since 2021-07-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution058 {

  public static int lengthOfLastWord(String s) {
    int i = s.length() - 1;
    while (i >= 0 && !Character.isLetter(s.charAt(i))) i--;

    int ans = 0;
    while (i >= 0 && Character.isLetter(s.charAt(i--))) ans++;
    return ans;
  }

  public static void main(String[] args) {
    String s = "Hello world+";
    System.out.println(lengthOfLastWord(s));
  }
}
