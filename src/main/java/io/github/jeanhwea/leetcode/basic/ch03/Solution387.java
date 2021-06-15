package io.github.jeanhwea.leetcode.basic.ch03;

import java.util.*;

/**
 * 字符串中的第一个唯一字符
 *
 * @author Jinghui Hu
 * @since 2021-06-09, JDK1.8
 */
public class Solution387 {

  public static int firstUniqChar(String s) {
    int n = s.length();
    Map<Character, Integer> mp = new HashMap<>();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      int v = mp.getOrDefault(ch, 0) + 1;
      mp.put(ch, v);
    }

    for (int i = 0; i < n; i++) {
      if (1 == mp.get(s.charAt(i))) return i;
    }

    return -1;
  }

  public static void main(String args[]) {
    String s = "loveleetcode";
    System.out.println(firstUniqChar(s));

    System.out.println("");

    String s1 = "leetcode";
    System.out.println(firstUniqChar(s1));
  }
}
