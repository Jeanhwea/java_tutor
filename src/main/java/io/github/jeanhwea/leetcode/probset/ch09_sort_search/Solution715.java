package io.github.jeanhwea.leetcode.probset.ch09_sort_search;

import java.util.*;

/**
 * Range 模块
 *
 * @author Jinghui Hu
 * @since 2021-08-17, JDK1.8
 */
@SuppressWarnings("all")
public class Solution715 {

  static class RangeModule {
    private TreeSet<Interval> ranges;

    public RangeModule() {
      ranges = new TreeSet<>();
    }

    // 添加 [left, right) 区间
    public void addRange(int left, int right) {
      Iterator<Interval> iter = ranges.tailSet(new Interval(0, left - 1)).iterator();
      while (iter.hasNext()) {
        Interval interval = iter.next();
        if (right < interval.left) break;
        left = Math.min(left, interval.left);
        right = Math.max(right, interval.right);
        iter.remove();
      }
      ranges.add(new Interval(left, right));
    }

    // 查询是否包含 [left, right) 区间
    public boolean queryRange(int left, int right) {
      Interval interval = ranges.higher(new Interval(0, left));
      return (interval != null && interval.left <= left && right <= interval.right);
    }

    // 移除 [left, right) 区间
    public void removeRange(int left, int right) {
      Iterator<Interval> iter = ranges.tailSet(new Interval(0, left)).iterator();
      ArrayList<Interval> todoList = new ArrayList();
      while (iter.hasNext()) {
        Interval interval = iter.next();
        if (right < interval.left) break;
        if (interval.left < left) todoList.add(new Interval(interval.left, left));
        if (right < interval.right) todoList.add(new Interval(right, interval.right));
        iter.remove();
      }
      for (Interval interval : todoList) ranges.add(interval);
    }

    class Interval implements Comparable<Interval> {
      int left, right;

      public Interval(int left, int right) {
        this.left = left;
        this.right = right;
      }

      @Override
      public int compareTo(Interval that) {
        if (this.right == that.right) return this.left - this.right;
        return this.right - that.right;
      }
    }
  }

  public static void main(String[] args) {
    // pass
  }
}
