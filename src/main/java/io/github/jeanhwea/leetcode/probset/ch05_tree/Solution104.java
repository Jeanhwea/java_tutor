package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 二叉树的最大深度
 *
 * @author Jinghui Hu
 * @since 2021-08-15, JDK1.8
 */
@SuppressWarnings("all")
public class Solution104 {

  // DFS
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  // BFS 层序遍历
  public int maxDepth1(TreeNode root) {
    if (root == null) return 0;
    int depth = 0;
    Deque<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      depth++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode p = queue.poll();
        if (p.left != null) queue.offer(p.left);
        if (p.right != null) queue.offer(p.right);
      }
    }
    return depth;
  }

  public static void main(String[] args) {
    // pass
  }
}
