package io.github.jeanhwea.leetcode.probset.ch01;

/**
 * 寻找两个正序数组的中位数
 *
 * @author Jinghui Hu
 * @since 2021-06-29, JDK1.8
 */
@SuppressWarnings("all")
public class Solution004 {

  // 双指针合并数组
  public static double findMedianSortedArrays1(int[] a, int[] b) {
    int n = a.length, m = b.length, i = 0, j = 0, u = 0, v = 0;

    for (int k = (n + m) / 2; k >= 0; k--) {
      v = u;
      if (i < n && j < m) {
        u = a[i] < b[j] ? a[i++] : b[j++];
      } else if (i < n) {
        u = a[i++];
      } else {
        u = b[j++];
      }
    }

    return (n + m) % 2 == 0 ? (double) (u + v) / 2 : (double) u;
  }

  // 采用分治法
  public static double findMedianSortedArrays(int[] a, int[] b) {
    int n = a.length, m = b.length;
    if ((n + m) % 2 == 0) {
      double u = findKth(a, 0, b, 0, (n + m) / 2);
      double v = findKth(a, 0, b, 0, (n + m) / 2 + 1);
      return (u + v) / 2;
    } else {
      return findKth(a, 0, b, 0, (n + m) / 2 + 1);
    }
  }

  // 查找有序数组 a[i...], b[j...] 的第 k 个小的数
  public static double findKth(int[] a, int i, int[] b, int j, int k) {
    int n = a.length - i, m = b.length - j;
    if (n > m) return findKth(b, j, a, i, k);
    if (n == 0) return b[j + k - 1];
    if (k == 1) return Math.min(a[i], b[j]);

    int x = Math.min(k / 2, n), y = k - x;
    if (a[i + x - 1] < b[j + y - 1]) {
      return findKth(a, i + x, b, j, k - x);
    } else if (a[i + x - 1] > b[j + y - 1]) {
      return findKth(a, i, b, j + y, k - y);
    }
    return (double) a[i + x - 1];
  }

  public static void main(String[] args) {
    // int[] a = {2}, b = {3};
    int[] a = {1, 2, 3, 4, 5}, b = {3, 4, 5};
    System.out.println(findMedianSortedArrays(a, b));
  }
}
