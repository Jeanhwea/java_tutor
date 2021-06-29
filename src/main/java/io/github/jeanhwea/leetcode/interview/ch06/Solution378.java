package io.github.jeanhwea.leetcode.interview.ch06;

import java.util.*;

/**
 * 有序矩阵中第K小的元素
 *
 * @author Jinghui Hu
 * @since 2021-06-18, JDK1.8
 */
@SuppressWarnings("all")
public class Solution378 {

  // 暴露搜索
  public static int kthSmallest0(int[][] a, int k) {
    int n = a.length;
    PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++) {
        if (pq.size() < k) {
          pq.offer(a[i][j]);
        } else if (a[i][j] < pq.peek()) {
          pq.poll();
          pq.offer(a[i][j]);
        }
      }
    return pq.peek();
  }

  public static int kthSmallest(int[][] a, int k) {
    int n = a.length;
    int lo = a[0][0], hi = a[n - 1][n - 1];
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (check(a, mid, n, k)) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }

  /**
   * 利用矩阵按行或按列都递增的性质
   * <li>从矩阵左下向右上查找
   * <li>变量 count 记录小于等于 mid 值的数量
   *
   * @author Jinghui Hu
   * @since 2021-06-18, JDK1.8
   */
  public static boolean check(int[][] a, int mid, int n, int k) {
    int i = n - 1, j = 0, count = 0;
    while (i >= 0 && j < n) {
      if (a[i][j] <= mid) {
        count += i + 1;
        j++;
      } else {
        i--;
      }
    }
    return count >= k;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
    System.out.println(kthSmallest(matrix, 8));
  }
}
