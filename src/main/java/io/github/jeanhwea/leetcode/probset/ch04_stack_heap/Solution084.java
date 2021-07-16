package io.github.jeanhwea.leetcode.probset.ch04_stack_heap;

import java.util.*;

/**
 * 柱状图中最大的矩形
 *
 * @author Jinghui Hu
 * @since 2021-07-12, JDK1.8
 */
@SuppressWarnings("all")
public class Solution084 {

  // 单调栈
  public static int largestRectangleArea(int[] a) {
    int n = a.length;
    int[] left = new int[n];
    int[] right = new int[n];

    Deque<Integer> stack = new LinkedList<>();

    int ans = 0;
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
        stack.pop();
      }
      left[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(i);
    }

    stack.clear();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
        stack.pop();
      }
      right[i] = stack.isEmpty() ? n : stack.peek();
      stack.push(i);
    }
    // System.out.println(Arrays.toString(left));
    // System.out.println(Arrays.toString(right));

    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, (right[i] - left[i] - 1) * a[i]);
    }

    return ans;
  }

  public static void main(String[] args) {
    // int[] heights = {2, 1, 6, 6, 2, 3};
    int[] heights = {0, 9};
    System.out.println(largestRectangleArea(heights));
  }
}
