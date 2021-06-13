package io.github.jeanhwea.leetcode.basic.ch08;

import java.util.*;

/**
 * Fizz Buzz
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution412 {

  public static List<String> fizzBuzz(int n) {
    List<String> ans = new LinkedList<String>();
    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        ans.add("FizzBuzz");
      } else if (i % 3 == 0) {
        ans.add("Fizz");
      } else if (i % 5 == 0) {
        ans.add("Buzz");
      } else {
        ans.add(String.valueOf(i));
      }
    }
    return ans;
  }

  public static void main(String args[]) {
    System.out.println(Arrays.toString(fizzBuzz(15).toArray()));
  }
}
