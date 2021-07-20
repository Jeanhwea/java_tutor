package io.github.jeanhwea.leetcode.probset.ch13_misc;

import java.util.*;

/**
 * 杨辉三角 II
 *
 * @author Jinghui Hu
 * @since 2021-07-20, JDK1.8
 */
@SuppressWarnings("all")
public class Solution119 {

  // 模拟法
  public static List<Integer> getRow(int rowIndex) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < rowIndex; i++) {
      ans.add(1);
      for (int j = i - 1; j > 0; j--) {
        ans.set(j, ans.get(j) + ans.get(j - 1));
      }
      // System.out.println(ans);
    }
    return ans;
  }

  public static void main(String[] args) {
    for (int i = 1; i < 10; i++) {
      System.out.println(getRow(i));
    }
  }
}
