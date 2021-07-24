package io.github.jeanhwea.leetcode.basic.ch10_misc;

import java.util.*;

/**
 * 杨辉三角
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
@SuppressWarnings("all")
public class Solution118 {

  public static List<List<Integer>> generate(int n) {
    List<List<Integer>> ans = null;
    if (n <= 1) {
      ans = new ArrayList<>();
      List<Integer> row = new ArrayList<>();
      row.add(1);
      ans.add(row);
      return ans;
    }

    ans = generate(n - 1);
    List<Integer> prev = ans.get(n - 2);
    List<Integer> curr = new ArrayList<>();
    curr.add(1);
    for (int j = 0; j < prev.size() - 1; j++) {
      curr.add(prev.get(j) + prev.get(j + 1));
    }
    curr.add(1);
    ans.add(curr);

    return ans;
  }

  public static List<List<Integer>> generate0(int n) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> row = new ArrayList<>();
    row.add(1);
    ans.add(row);

    for (int i = 1; i < n; i++) {
      List<Integer> prev = ans.get(i - 1);
      List<Integer> curr = new ArrayList<>();
      curr.add(1);
      for (int j = 0; j < prev.size() - 1; j++) {
        curr.add(prev.get(j) + prev.get(j + 1));
      }
      curr.add(1);
      ans.add(curr);
    }

    return ans;
  }

  public static void main(String[] args) {
    List<List<Integer>> ans = generate(5);
    System.out.println("");
  }
}
