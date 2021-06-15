package io.github.jeanhwea.leetcode;

import java.util.*;

public class Solution {

  public static List<String> tokenize(String s, List<String> dict) {
    List<List<String>> sentences = new LinkedList<>();
    Set<String> validWord = new HashSet<>(dict);

    List<String> ans = new LinkedList<>();
    for (int i = 0; i < sentences.size(); i++) {
      String str = String.join(" ", sentences.get(i));
      ans.add(str);
    }
    return ans;
  }

  public static void main(String args[]) {
    String s = "abcb";
    List<String> dict = Arrays.asList("a", "bc", "ac");
    System.out.println(s);
    System.out.println(dict);
    System.out.println("========================================");
    tokenize(s, dict);
  }
}
