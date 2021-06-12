package io.github.jeanhwea.leetcode.basic.ch04;

import java.util.*;

/**
 * 对称二叉树
 *
 * @author Jinghui Hu
 * @since 2021-06-12, JDK1.8
 */
public class Solution101 {

  public static boolean isSymmetric(TreeNode root) {
    if (root == null) return true;

    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      Object[] currLevel = nodes.toArray();

      int i = 0, j = size - 1;
      while (i <= j) {
        TreeNode n1 = (TreeNode) currLevel[i], n2 = (TreeNode) currLevel[j];
        if (n1.left != null || n2.right != null) {
          if (n1.left == null || n2.right == null || n1.left.val != n2.right.val) {
            return false;
          }
        }

        if (n1.right != null || n2.left != null) {
          if (n1.right == null || n2.left == null || n1.right.val != n2.left.val) {
            return false;
          }
        }

        if (n1.left == null && n1.right == null) {
          if (n2.left != null || n2.right != null) {
            return false;
          }
        }

        i++;
        j--;
      }

      for (int k = 0; k < size; k++) {
        TreeNode p = nodes.poll();
        if (p.left != null) nodes.offer(p.left);
        if (p.right != null) nodes.offer(p.right);
      }
    }
    return true;
  }

  public static void main(String args[]) {
    TreeNode tree = TreeNode.makeTree(new int[] {2, 3, 3});
    TreeNode.display(tree);
    System.out.println("========================================");
    System.out.println(isSymmetric(tree));
  }
}
