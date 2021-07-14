package io.github.jeanhwea.leetcode.probset.ch05;

import java.util.*;

/**
 * 平衡二叉树
 *
 * @author Jinghui Hu
 * @since 2021-07-14, JDK1.8
 */
@SuppressWarnings("all")
public class Solution110 {

  private static Map<TreeNode, Integer> cache;

  // 后序遍历缓存高度
  public static boolean isBalanced0(TreeNode root) {
    if (root == null) return true;

    cache = new HashMap<>();
    calcHeight(root);

    return Math.abs(cache.getOrDefault(root.left, 0) - cache.getOrDefault(root.right, 0)) <= 1
        && isBalanced(root.left)
        && isBalanced(root.right);
  }

  public static void calcHeight(TreeNode root) {
    if (root == null) return;
    calcHeight(root.left);
    calcHeight(root.right);
    int rootHeight =
        Math.max(cache.getOrDefault(root.left, 0), cache.getOrDefault(root.right, 0)) + 1;
    cache.put(root, rootHeight);
  }

  // 直接计算
  public static boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    return Math.abs(height(root.left) - height(root.right)) <= 1
        && isBalanced(root.left)
        && isBalanced(root.right);
  }

  public static int height(TreeNode root) {
    if (root == null) return 0;
    return Math.max(height(root.left), height(root.right)) + 1;
  }

  public static void main(String[] args) {
    // pass
  }
}
