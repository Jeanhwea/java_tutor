package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 翻转二叉树
 *
 * @author Jinghui Hu
 * @since 2021-08-29, JDK1.8
 */
@SuppressWarnings("all")
public class Solution226 {

  public static TreeNode invertTree(TreeNode root) {
    if (root == null) return root;
    TreeNode invertedLeft = invertTree(root.left);
    TreeNode invertedRight = invertTree(root.right);
    root.left = invertedRight;
    root.right = invertedLeft;
    return root;
  }

  public static void main(String[] args) {
    TreeNode tree01 = TreeNode.makeTree(new int[] {1, 2, 3, 4, 5});
    TreeNode.dispTree(invertTree(tree01));
  }
}
