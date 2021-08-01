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
    if (matrix.length == 0 || matrix[0].length == 0) return 0;
    int n = matrix.length, m = matrix[0].length;
    int[][] left = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == '1') {
          left[i][j] = (j <= 0 ? 0 : left[i][j - 1]) + 1;
        }
      }
    }
    // System.out.println(Arrays.deepToString(left).replaceAll("],", "],\n"));

    // 单调栈求解柱状图面积问题
    int ans = 0;
    for (int j = 0; j < m; j++) { // 每一列都是一个计算柱状图最大面积问题
      int[] top = new int[n], bottum = new int[n];
      Deque<Integer> stack = new LinkedList<>();
      for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) stack.pop();
        top[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(i);
      }
      stack.clear();
      for (int i = n - 1; i >= 0; i--) {
        while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) stack.pop();
        bottum[i] = stack.isEmpty() ? n : stack.peek();
        stack.push(i);
      }
      for (int i = 0; i < n; i++) {
        ans = Math.max(ans, (bottum[i] - top[i] - 1) * left[i][j]);
      }
    }
    return ans;
  }

  public static int maximalRectangle0(char[][] matrix) {
    // n*m matrix
    int n = matrix.length;
    if (n == 0) return 0;
    int m = matrix[0].length;
    int[][] left = new int[n][m];

    // 计算左边 1 的个数
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == '1') {
          left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
        }
      }
    }
    // System.out.println(Arrays.deepToString(left).replaceAll("],", "],\n"));

    // 枚举所有可能的矩形，选出最大的矩形
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == '0') continue;
        int width = left[i][j];
        int area = width;
        for (int k = i - 1; k >= 0; k--) {
          width = Math.min(width, left[k][j]);
          area = Math.max(area, (i - k + 1) * width);
        }
        ans = Math.max(ans, area);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    char[][] matrix = {
      {'1', '0', '1', '0', '0'},
      {'1', '0', '1', '1', '1'},
      {'1', '1', '1', '1', '1'},
      {'1', '0', '0', '1', '0'}
    };
    // char[][] matrix = {{'0', '1'}};
    System.out.println(maximalRectangle(matrix));
  }
}
