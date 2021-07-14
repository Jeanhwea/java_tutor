package io.github.jeanhwea.leetcode.probset.ch05;

import java.util.*;

/**
 * 相同的树
 *
 * @author Jinghui Hu
 * @since 2021-07-14, JDK1.8
 */
@SuppressWarnings("all")
public class Solution100 {

  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    if (p != null && q != null && p.val == q.val) {
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    return false;
  }

  public static void main(String[] args) {
    // pass
  }
}
