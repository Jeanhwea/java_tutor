package io.github.jeanhwea.leetcode.interview.ch11_dp;

import java.util.*;

/**
 * 二叉树中的最大路径和
 *
 * @author Jinghui Hu
 * @since 2021-06-22, JDK1.8
 */
@SuppressWarnings("all")
public class Solution124 {

  private static int ans = Integer.MIN_VALUE;

  public static int maxPathSum0(TreeNode root) {
    Map<TreeNode, Integer> cache = new HashMap<>();
    postorder(root, cache);
    System.out.println(cache);
    return ans;
  }

  public static void postorder(TreeNode root, Map<TreeNode, Integer> cache) {
    if (root == null) return;

    if (root.left != null) {
      postorder(root.left, cache);
    }

    if (root.right != null) {
      postorder(root.right, cache);
    }

    int lVal = cache.getOrDefault(root.left, 0), rVal = cache.getOrDefault(root.right, 0);
    int val1 = Math.max(lVal, rVal) + root.val;
    // System.out.println(val1);
    cache.put(root, val1);

    int val = root.val + Math.max(lVal, 0) + Math.max(rVal, 0);
    if (val > ans) ans = val;
  }

  public static int maxPathSum(TreeNode root) {
    if (root == null) return 0;

    Map<TreeNode, Integer> cache = new HashMap<>();
    int maxVal = Integer.MIN_VALUE;

    Deque<TreeNode> nodes = new LinkedList<>();
    TreeNode prev = null;
    while (root != null || !nodes.isEmpty()) {
      while (root != null) {
        nodes.push(root);
        root = root.left;
      }
      root = nodes.peek();
      if (root.right == prev || root.right == null) {
        int val1 = cache.getOrDefault(root.left, 0);
        int val2 = cache.getOrDefault(root.right, 0);
        int val = root.val + Math.max(Math.max(val1, val2), 0);
        cache.put(root, val);

        int currVal = root.val + Math.max(val1, 0) + Math.max(val2, 0);
        maxVal = Math.max(maxVal, currVal);

        prev = nodes.pop();
        root = null;
      } else {
        root = root.right;
      }
    }

    return maxVal;
  }

  public static void main(String[] args) {
    TreeNode tree1 = TreeNode.makeTree(new int[] {-10, 9, 20, -1, -1, 15, 7});
    TreeNode.dispTree(tree1);
    System.out.println(maxPathSum0(tree1));
    System.out.println(maxPathSum(tree1));
    // TreeNode tree2 = TreeNode.makeTree(new int[] {5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, 1});
    // TreeNode.dispTree(tree2);
    // System.out.println(maxPathSum0(tree2));
    // System.out.println(maxPathSum(tree2));
  }
}
