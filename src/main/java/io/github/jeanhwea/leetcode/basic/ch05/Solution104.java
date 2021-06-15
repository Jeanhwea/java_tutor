package io.github.jeanhwea.leetcode.basic.ch05;

import java.util.*;

/**
 * 二叉树的最大深度
 *
 * @author Jinghui Hu
 * @since 2021-06-11, JDK1.8
 */
public class Solution104 {

  // 层次遍历
  public static int maxDepth(TreeNode root) {
    if (root == null) return 0;

    int depth = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      depth++;
      int n = queue.size();
      for (int i = 0; i < n; i++) {
        TreeNode p = queue.poll();
        if (p.left != null) queue.offer(p.left);
        if (p.right != null) queue.offer(p.right);
      }
    }
    return depth;
  }

  // 递归版
  public static int maxDepth1(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }

  public static void main(String args[]) {
    TreeNode tree = TreeNode.makeTree(new int[] {1, 2, 3, 4, -1, -1, -1, 5});
    System.out.println(maxDepth(tree));
  }
}
