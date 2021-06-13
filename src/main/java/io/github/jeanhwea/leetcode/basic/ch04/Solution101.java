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

    Queue<TreeNode> n1 = new LinkedList<>();
    Queue<TreeNode> n2 = new LinkedList<>();
    n1.offer(root);
    n2.offer(root);

    while (!n1.isEmpty()) {
      TreeNode p1 = n1.poll(), p2 = n2.poll();
      if (p1 != null && p2 == null) return false;
      if (p2 != null && p1 == null) return false;
      if (p1 != null && p2 != null && p1.val != p2.val) return false;

      if (p1 != null) {
        n1.offer(p1.left);
        n2.offer(p2.right);
        n1.offer(p1.right);
        n2.offer(p2.left);
      }
    }

    return true;
  }

  public static boolean isSymmetric0(TreeNode root) {
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
    TreeNode tree1 = TreeNode.makeTree(new int[] {2, 3, 3});
    TreeNode.display(tree1);
    System.out.println("========================================");
    System.out.println(isSymmetric(tree1));

    TreeNode tree2 = TreeNode.makeTree(new int[] {2});
    TreeNode.display(tree2);
    System.out.println("========================================");
    System.out.println(isSymmetric(tree2));

    TreeNode tree3 = TreeNode.makeTree(new int[] {1, 2, 2, 4, -1, 4});
    TreeNode.display(tree3);
    System.out.println("========================================");
    System.out.println(isSymmetric(tree3));
  }
}
