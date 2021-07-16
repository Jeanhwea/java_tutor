package io.github.jeanhwea.leetcode.probset.ch01_array;

import java.util.*;

/**
 * 接雨水
 *
 * @author Jinghui Hu
 * @since 2021-07-07, JDK1.8
 */
@SuppressWarnings("all")
public class Solution042 {

  // 双指针
  public static int trap(int[] height) {
    int n = height.length;
    int left = 0, right = n - 1, leftMax = 0, rightMax = 0, ans = 0;
    while (left < right) {
      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);
      if (leftMax < rightMax) {
        ans += leftMax - height[left++];
      } else {
        ans += rightMax - height[right--];
      }
    }
    return ans;
  }

  // 动态规划
  public static int trap1(int[] height) {
    int n = height.length;
    int[] leftBound = new int[n], rightBound = new int[n];

    for (int i = 1; i < n; i++) {
      leftBound[i] = Math.max(leftBound[i - 1], height[i - 1]);
    }
    for (int i = n - 2; i >= 0; i--) {
      rightBound[i] = Math.max(rightBound[i + 1], height[i + 1]);
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans += Math.max(Math.min(leftBound[i], rightBound[i]) - height[i], 0);
    }

    return ans;
  }

  public static int trap0(int[] height) {
    int n = height.length;
    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
    for (int i = 0; i < n; i++) {
      pq.offer(new int[] {i, height[i]});
    }

    int ans = 0, curr = -1;
    List<Integer> list = new ArrayList<>();
    while (!pq.isEmpty()) {
      int[] e = pq.poll();

      curr = e[1];
      list.add(e[0]);
      while (!pq.isEmpty() && pq.peek()[1] == curr) {
        list.add(pq.poll()[0]);
      }
      Collections.sort(list);
      // System.out.println(list);

      int left = list.get(0);
      int count = 0;
      for (int i = 1; i < list.size(); i++) {
        count += list.get(i) - left - 1;
        left = list.get(i);
      }
      // System.out.println(count);
      int next = pq.isEmpty() ? 0 : pq.peek()[1];
      ans += count * (curr - next);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    // int[] height = {4, 2, 0, 3, 2, 5};
    System.out.println(trap(height));
  }
}
