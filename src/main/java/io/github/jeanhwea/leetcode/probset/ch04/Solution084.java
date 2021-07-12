package io.github.jeanhwea.leetcode.probset.ch04;

import java.util.*;

/**
 * 柱状图中最大的矩形
 *
 * @author Jinghui Hu
 * @since 2021-07-12, JDK1.8
 */
@SuppressWarnings("all")
public class Solution084 {

  public static int largestRectangleArea(int[] a) {
    int n = a.length;

    Deque<int[]> stack = new LinkedList<>();
    stack.push(new int[] {-1, 0});

    int ans = 0;
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && stack.peek()[1] > a[i]) {
        stack.pop();
      }
      stack.push(new int[] {i, a[i]});

      for (int[] e : stack) {
        int area = (i - e[0] + 1) * e[1];
        ans = Math.max(ans, area);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] heights = {2, 1, 6, 6, 2, 3};
    System.out.println(largestRectangleArea(heights));
  }
}
