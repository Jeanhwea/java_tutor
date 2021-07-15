package io.github.jeanhwea.realworld;

import java.util.*;

/**
 * 层序遍历二叉树
 *
 * @author Jinghui Hu
 * @since 2021-07-15, JDK1.8
 */
@SuppressWarnings("all")
public class Problem0715 {

  public static class TreeNode {
    String val;
    TreeNode left, right;

    public TreeNode(String val) {
      this.val = val;
    }
  }

  public static void printTree(TreeNode root) {
    if (root == null) return;

    Deque<TreeNode> que = new LinkedList<>();
    que.offer(root);
    while (!que.isEmpty()) {
      int size = que.size();
      for (int i = 0; i < size; i++) {
        TreeNode p = que.poll();
        System.out.printf("%s ", p.val);
        if (p.left != null) que.offer(p.left);
        if (p.right != null) que.offer(p.right);
      }
      System.out.println("");
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode("root");

    TreeNode n1 = new TreeNode("n1");
    TreeNode n2 = new TreeNode("n2");
    root.left = n1;
    root.right = n2;

    TreeNode n3 = new TreeNode("n3");
    TreeNode n4 = new TreeNode("n4");
    n1.left = n3;
    n1.right = n4;

    printTree(root);
  }
}
