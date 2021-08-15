package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 验证二叉搜索树
 *
 * @author Jinghui Hu
 * @since 2021-08-14, JDK1.8
 */
@SuppressWarnings("all")
public class Solution098 {

  ////////////////////////////////////////////////////////////////////////////////
  // 迭代版
  ////////////////////////////////////////////////////////////////////////////////
  public static boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    TreeNode prev = null;
    Deque<TreeNode> stack = new LinkedList<>();
    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (prev != null && prev.val >= root.val) return false;
      prev = root;
      root = root.right;
    }
    return true;
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 递归版
  ////////////////////////////////////////////////////////////////////////////////
  public static boolean isValidBST0(TreeNode root) {
    prev = null;
    return traverse(root);
  }

  private static TreeNode prev;

  private static boolean traverse(TreeNode root) {
    if (root == null) return true;
    if (!traverse(root.left)) return false;
    if (prev != null && prev.val >= root.val) {
      return false;
    } else {
      prev = root;
    }
    if (!traverse(root.right)) return false;
    return true;
  }

  public static void main(String[] args) {
    // pass
  }
}
