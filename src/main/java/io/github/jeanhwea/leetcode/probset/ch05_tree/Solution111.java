package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 二叉树的最小深度
 *
 * @author Jinghui Hu
 * @since 2021-08-15, JDK1.8
 */
@SuppressWarnings("all")
public class Solution111 {

  // DFS 深度优先搜索
  public static int minDepth(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null) {
      return minDepth(root.right) + 1;
    } else if (root.right == null) {
      return minDepth(root.left) + 1;
    } else if (root.left == null && root.right == null) {
      return 1;
    } else {
      return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
  }

  // BFS 广度优先搜索
  public static int minDepth1(TreeNode root) {
    if (root == null) return 0;
    int depth = 1;
    Deque<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode p = queue.poll();
        if (p.left == null && p.right == null) return depth;
        if (p.left != null) queue.offer(p.left);
        if (p.right != null) queue.offer(p.right);
      }
      ++depth;
    }
    return depth;
  }

  public static void main(String[] args) {
    // pass
  }
}
