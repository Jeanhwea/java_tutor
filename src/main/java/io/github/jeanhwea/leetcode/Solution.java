package io.github.jeanhwea.leetcode;

import java.util.*;

public class Solution {

  public static int[] maxSlidingWindow(int[] a, int k) {
    int n = a.length;
    int[] b = new int[n - k + 1];
    Deque<Integer> dq = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (dq.isEmpty() || a[dq.getLast()] > a[i]) {
        dq.addLast(i);
      } else {
        while (dq.isEmpty() || a[dq.getLast()] >= a[i]) {
          dq.removeLast();
        }
        dq.addLast(i);
      }
      if (i >= k) {
        while (dq.getFirst() < i - k) {
          dq.removeFirst();
        }
        b[i] = a[dq.peekFirst()];
      }
    }
    return b;
  }

  public static void main(String[] args) {
    int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
    maxSlidingWindow(a, 3);
  }
}
