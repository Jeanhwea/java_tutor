package io.github.jeanhwea.leetcode.interview.ch09;

import java.util.*;

/**
 * 二叉搜索树中第K小的元素
 *
 * @author Jinghui Hu
 * @since 2021-06-15, JDK1.8
 */
@SuppressWarnings("all")
public class Solution230 {

  public static int kthSmallest(TreeNode root, int k) {
    if (root == null) return -1;

    Deque<TreeNode> nodes = new LinkedList<>();
    int count = 0;
    while (root != null || !nodes.isEmpty()) {
      while (root != null) {
        nodes.push(root);
        root = root.left;
      }

      root = nodes.pop();
      // System.out.printf("[%d]=%d\n", count, root.val);

      if (++count >= k) {
        return root.val;
      }

      if (root.right != null) {
        root = root.right;
      } else {
        root = null;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    TreeNode tree1 = TreeNode.makeTree(new int[] {3, 1, 4, -1, 2});
    TreeNode.dispTree(tree1);
    System.out.println("========================================");
    for (int k = 1; k < 5; k++) {
      System.out.println(kthSmallest(tree1, k));
    }
  }
}
