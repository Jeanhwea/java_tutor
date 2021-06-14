package io.github.jeanhwea.scratch;

import java.util.*;

/**
 * 优先队列，堆，堆排序
 *
 * @author Jinghui Hu
 * @since 2021-06-06, JDK1.8
 */
public class DataStructure03 {

  /**
   * 优先队列的堆实现方式使用：上浮 (swim) 和下沉 (sink) 两个操作
   *
   * @author Jinghui Hu
   * @since 2021-06-06, JDK1.8
   */
  public static void swim(int[] a, int s) {
    int p = (s - 1) / 2;
    while (true) {
      if (s > 0 && a[p] < a[s]) {
        int t = a[s];
        a[s] = a[p];
        a[p] = t;
      } else break;

      s = p;
      p = (s - 1) / 2;
    }
  }

  public static void sink(int[] a, int p, int n) {
    int mi = p;
    while (true) {
      int s = 2 * p + 1;
      while (s < n && a[s] < a[mi]) mi = s;
      ++s;
      while (s < n && a[s] < a[mi]) mi = s;
      if (p == mi) break;

      int t = a[mi];
      a[mi] = a[p];
      a[p] = t;
      p = mi;
    }
  }

  ////////////////////////////////////////////////////////////////////////////////

  /**
   * 最大堆满足：k+1 层的元素大于 k 层元素
   *
   * @author Jinghui Hu
   * @since 2021-06-06, JDK1.8
   */
  public static void heaplify(int[] a, int p, int n) {
    int l = 2 * p + 1, r = 2 * p + 2, ma = p;
    while (true) {
      if (l < n && a[l] > a[ma]) ma = l;
      if (r < n && a[r] > a[ma]) ma = r;
      if (p != ma) {
        int t = a[ma];
        a[ma] = a[p];
        a[p] = t;
      } else break;

      // fix broken children
      p = ma;
      l = 2 * p + 1;
      r = 2 * p + 2;
    }
  }

  public static void makeHeap(int[] a, int n) {
    for (int i = n / 2 - 1; i >= 0; i--) {
      heaplify(a, i, n);
    }
  }

  /**
   * 堆排序
   *
   * @author Jinghui Hu
   * @since 2021-06-06, JDK1.8
   */
  public static void hsort(int[] a) {
    makeHeap(a, a.length);
    for (int i = a.length - 1; i >= 1; --i) {
      int t = a[i];
      a[i] = a[0];
      a[0] = t;
      makeHeap(a, i);
    }
  }

  public static void main(String args[]) {
    int[] a = makeArray(8);
    int[] b = makeArray(6);
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));
    System.out.println("========================================");

    PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
    for (int i = 0; i < 8; i++) {
      Pair p = new Pair("E" + i, a[i]);
      pq.offer(p);
    }
    for (int i = 0; i < 8; i++) {
      Pair e = pq.poll();
      System.out.printf("%s %d\n", e.key, e.value);
    }
  }

  private static class Pair {
    public String key;
    public int value;

    public Pair(String key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private static int[] makeArray(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      int e = (int) (1 + Math.random() * 30);
      a[i] = e;
    }
    return a;
  }
}
