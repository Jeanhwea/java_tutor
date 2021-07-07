package io.github.jeanhwea.leetcode.probset.ch01;

import java.util.*;

/**
 * 接雨水
 *
 * @author Jinghui Hu
 * @since 2021-07-07, JDK1.8
 */
@SuppressWarnings("all")
public class Solution042 {

  public static int trap(int[] height) {
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
    // int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int[] height = {4, 2, 0, 3, 2, 5};
    System.out.println(trap(height));
  }
}
