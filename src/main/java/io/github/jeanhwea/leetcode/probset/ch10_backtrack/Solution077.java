package io.github.jeanhwea.leetcode.probset.ch10_backtrack;

import java.util.*;

/**
 * 组合
 *
 * @author Jinghui Hu
 * @since 2021-07-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution077 {

  private static int len, threshold;
  private static List<List<Integer>> ans;
  private static List<Integer> choose;

  private static void backtrack(int i) {
    if (i == len) {
      if (choose.size() == threshold) {
        ans.add(new ArrayList<Integer>(choose));
      }
      return;
    }

    backtrack(i + 1);

    choose.add(i + 1);
    backtrack(i + 1);
    choose.remove(choose.size() - 1);
  }

  public static List<List<Integer>> combine(int n, int k) {
    len = n;
    threshold = k;
    ans = new LinkedList<>();
    choose = new LinkedList<>();

    backtrack(0);
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(combine(3, 2));
  }
}
