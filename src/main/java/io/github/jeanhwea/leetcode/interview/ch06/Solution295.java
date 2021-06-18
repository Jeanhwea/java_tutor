package io.github.jeanhwea.leetcode.interview.ch06;

import java.util.*;

/**
 * 数据流的中位数
 *
 * @author Jinghui Hu
 * @since 2021-06-18, JDK1.8
 */
public class Solution295 {

  public static class MedianFinder {

    PriorityQueue<Integer> small, large;

    public MedianFinder() {
      small = new PriorityQueue<>((x, y) -> y - x);
      large = new PriorityQueue<>();
    }

    public void addNum(int num) {
      if (small.isEmpty()) {
        small.offer(num);
      } else if (large.isEmpty()) {
        if (num < small.peek()) {
          large.offer(small.poll());
          small.offer(num);
        } else {
          large.offer(num);
        }
      } else {
        int s = small.peek();
        if (num <= s) {
          if (small.size() > large.size()) {
            large.offer(small.poll());
          }
          small.offer(num);
        } else {
          if (large.size() >= small.size()) {
            small.offer(large.poll());
          }
          large.offer(num);
        }
      }
    }

    public double findMedian() {
      if (small.isEmpty()) return -1;
      else if (large.isEmpty()) {
        return small.peek();
      }

      if (small.size() == large.size()) {
        return ((double) (small.peek() + large.peek())) / 2;
      } else {
        return (double) small.peek();
      }
    }
  }

  public static void main(String[] args) {
    MedianFinder obj = new MedianFinder();
    obj.addNum(-1);
    System.out.println(obj.findMedian());
    obj.addNum(-2);
    System.out.println(obj.findMedian());
    obj.addNum(-3);
    System.out.println(obj.findMedian());
    obj.addNum(-4);
    System.out.println(obj.findMedian());
    obj.addNum(-5);
    System.out.println(obj.findMedian());
  }
}
