package io.github.jeanhwea.leetcode.probset.ch09_sort_search;

import java.util.*;

/**
 * 重构 2 行二进制矩阵
 *
 * @author Jinghui Hu
 * @since 2021-08-17, JDK1.8
 */
@SuppressWarnings("all")
public class Solution1253 {

  // 贪心算法
  public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
    int n = colsum.length;
    ArrayList<Integer> a = new ArrayList<>(n), b = new ArrayList<>(n);
    // 第一次遍历处理和为 2 的列
    for (int i = 0; i < n; i++) {
      if (colsum[i] == 2) {
        if (upper > 0 && lower > 0) {
          a.add(1); b.add(1); upper--; lower--;
        } else {
          return Collections.emptyList();
        }
      } else {
        a.add(0); b.add(0);
      }
    }
    // 第二次遍历处理和为 1 的列
    for (int i = 0; i < n; i++) {
      if (colsum[i] == 1) {
        if (upper > 0) {
          a.set(i, 1); upper--;
        } else if (lower > 0) {
          b.set(i, 1); lower--;
        } else {
          return Collections.emptyList();
        }
      }
    }
    if (upper != 0 || lower != 0) return Collections.emptyList();
    List<List<Integer>> ans = new LinkedList<>();
    ans.add(a);
    ans.add(b);
    return ans;
  }

  public static void main(String[] args) {
    int upper = 2, lower = 2;
    int[] colsum = new int[] {1, 2, 1};
    System.out.println(reconstructMatrix(upper, lower, colsum));
  }
}
