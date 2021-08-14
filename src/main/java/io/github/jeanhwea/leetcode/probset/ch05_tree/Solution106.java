package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * @author Jinghui Hu
 * @since 2021-08-14, JDK1.8
 */
@SuppressWarnings("all")
public class Solution106 {

  public static TreeNode buildTree(int[] inorder, int[] postorder) {
    return consTree(inorder, postorder, 0, 0, inorder.length);
  }

  private static TreeNode consTree(int[] inorder, int[] postorder, int x, int y, int n) {
    int val = postorder[y + n - 1], i;
    for (i = x; i < x + n; i++) {
      if (val == inorder[i]) break;
    }
    TreeNode root = new TreeNode(val);
    if (i - x > 0) {
      root.left = consTree(inorder, postorder, x, y, i - x);
    }
    if (n - (i - x) - 1 > 0) {
      root.right = consTree(inorder, postorder, i + 1, y + (i - x), n - (i - x) - 1);
    }
    return root;
  }

  public static void main(String[] args) {
    // pass
  }
}
