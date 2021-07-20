package io.github.jeanhwea.leetcode.probset.ch08_dp;

import java.util.*;

/**
 * 最大矩形
 *
 * @author Jinghui Hu
 * @since 2021-07-20, JDK1.8
 */
@SuppressWarnings("all")
public class Solution085 {

  public static int maximalRectangle(char[][] matrix) {
    int ans = 0;
    return ans;
  }

  public static void main(String[] args) {
    char[][] matrix = {
      {'1', '0', '1', '0', '0'},
      {'1', '0', '1', '1', '1'},
      {'1', '1', '1', '1', '1'},
      {'1', '0', '0', '1', '0'}
    };
    System.out.println(maximalRectangle(matrix));
  }
}
