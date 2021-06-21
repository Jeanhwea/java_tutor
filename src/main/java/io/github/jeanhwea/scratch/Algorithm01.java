package io.github.jeanhwea.scratch;

import java.util.*;

/**
 * 各种排序算法
 *
 * @author Jinghui Hu
 * @since 2021-06-06, JDK1.8
 */
public class Algorithm01 {

  private static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 选择排序 selection sort
  public static void ssort(int[] a) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
      int mi = i; // min index
      for (int j = i + 1; j < n; j++) {
        if (a[j] < a[mi]) mi = j;
      }
      swap(a, i, mi);
    }
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 冒泡排序 bubble sort
  public static void bsort(int[] a) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (a[i] > a[j]) swap(a, i, j);
      }
    }
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 插入排序 insertion sort
  public static void isort(int[] a) {
    int n = a.length;
    for (int i = 0; i < n - 1; i++) {
      int v = a[i + 1];
      int j = 0;
      while (j <= i && a[j] < v) j++;
      for (int k = i + 1; k > j; k--) a[k] = a[k - 1];
      a[j] = v;
    }
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 快速排序 quick sort
  public static void qsort(int a[], int lo, int hi) {
    if (hi <= lo) return;

    int i = lo, j = hi;
    int p = a[i]; // pivot
    while (i < j) {
      // right scan
      while (j > i && a[j] >= p) j--;
      a[i] = a[j]; // a[i] is kept

      // left scan
      while (i < j && a[i] <= p) i++;
      a[j] = a[i]; // a[j] is kept
    }

    // now i equals j
    a[i] = p;

    qsort(a, lo, i - 1);
    qsort(a, i + 1, hi);
  }

  public static void qsort0(int a[], int lo, int hi) {
    if (hi <= lo) return;

    int[] b = new int[hi - lo + 1];
    for (int k = 0; k < b.length; k++) {
      b[k] = a[k + lo];
    }

    int i = lo, j = hi, p = b[0];
    for (int k = 1; k < b.length; k++) {
      if (b[k] < p) {
        a[i++] = b[k];
      } else {
        a[j--] = b[k];
      }
    }
    a[i] = p;

    qsort0(a, lo, i - 1);
    qsort0(a, i + 1, hi);
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 堆排序 heap sort
  public static void hsort(int[] a) {
    int n = a.length;
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
    for (int i = 0; i < n; i++) {
      heap.add(a[i]);
    }
    for (int i = 0; i < n; i++) {
      a[i] = heap.poll();
    }
  }

  public static void main(String[] args) {
    int arrSize = 6;
    int[] a = new int[arrSize];
    for (int i = 0; i < arrSize; i++) {
      int e = (int) (Math.random() * 30);
      a[i] = e;
    }

    System.out.println(Arrays.toString(a));
    System.out.println("========================================");
    // bsort(a);
    // isort(b);
    // isort(a);
    // qsort(a, 0, a.length - 1);
    // Arrays.sort(b); // JDK sort
    hsort(a);
    System.out.println(Arrays.toString(a));

    // int[] b = {9, 2, 3, 1, 9, 22, 0};
    // Arrays.sort(b); // JDK sort
    // System.out.println(Arrays.toString(b));
  }
}
