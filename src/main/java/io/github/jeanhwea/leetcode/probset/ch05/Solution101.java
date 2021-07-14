package io.github.jeanhwea.leetcode.probset.ch05;

import java.util.*;

/**
 * 对称二叉树
 *
 * @author Jinghui Hu
 * @since 2021-07-14, JDK1.8
 */
@SuppressWarnings("all")
public class Solution101 {

  public static boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return helper(root.left, root.right);
  }

  public static boolean helper(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p != null && q != null && p.val == q.val) {
      return helper(p.left, q.right) && helper(p.right, q.left);
    }
    return false;
  }

  public static void main(String[] args) {
    //
  }
}
