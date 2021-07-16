package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author Jinghui Hu
 * @since 2021-07-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution105 {

  // 递归法
  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTree(preorder, inorder, 0, 0, preorder.length);
  }

  public static TreeNode buildTree(int[] preorder, int[] inorder, int x, int y, int len) {
    if (len <= 0) return null;

    TreeNode root = new TreeNode(preorder[x]);
    if (len <= 1) return root;

    int i = y;
    while (i < y + len && inorder[i] != root.val) i++;

    root.left = buildTree(preorder, inorder, x + 1, y, i - y);
    root.right = buildTree(preorder, inorder, x + 1 + i - y, i + 1, len - (i - y) - 1);
    return root;
  }

  public static void main(String[] args) {
    int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
    TreeNode tree01 = buildTree(preorder, inorder);
    TreeNode.dispTree(tree01);
  }
}
