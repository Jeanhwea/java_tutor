package io.github.jeanhwea.leetcode.interview.ch06_heap_stack_queue;

import java.util.*;

/**
 * 数据流的中位数
 *
 * @author Jinghui Hu
 * @since 2021-06-18, JDK1.8
 */
@SuppressWarnings("all")
public class Solution295 {

  // 双堆缓存
  public static class MedianFinder {

    PriorityQueue<Integer> small, large;

    public MedianFinder() {
      small = new PriorityQueue<>((x, y) -> y - x);
      large = new PriorityQueue<>();
    }

    public void addNum(int num) {
      small.offer(num);
      large.offer(small.poll());
      if (large.size() > small.size()) {
        small.offer(large.poll());
      }
      // System.out.printf("%d: %s, %s\n", num, small, large);
    }

    public double findMedian() {
      if (small.size() == large.size()) {
        return 0.5 * (small.peek() + large.peek());
      } else {
        return (double) small.peek();
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 6, 3, 2, 3, 2, 9, 8};
    MedianFinder obj = new MedianFinder();
    for (int i = 0; i < a.length; i++) {
      obj.addNum(a[i]);
    }
    System.out.println(obj.findMedian());
  }
}
