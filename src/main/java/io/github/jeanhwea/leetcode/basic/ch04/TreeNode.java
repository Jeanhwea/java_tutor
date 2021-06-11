package io.github.jeanhwea.leetcode.basic.ch04;

import java.util.*;

/**
 * 二叉树节点
 *
 * @author Jinghui Hu
 * @since 2021-06-11, JDK1.8
 */
public class TreeNode {

  int val;
  TreeNode left, right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public static TreeNode makeTree(int[] a) {
    int n = a.length, m = 1;
    if (n <= 0) return null;
    TreeNode root = new TreeNode(a[0]);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode p = queue.poll();
        int c = m + 2 * i;
        if (c < n && a[c] > 0) {
          TreeNode q = new TreeNode(a[c]);
          p.left = q;
          queue.offer(q);
        }
        c++;
        if (c < n && a[c] > 0) {
          TreeNode q = new TreeNode(a[c]);
          p.right = q;
          queue.offer(q);
        }
      }
      m += 2 * size;
    }
    return root;
  }

  public static void main(String args[]) {
    TreeNode root = makeTree(new int[] {1, 2, 3, 4, 5});
    System.out.println("====");
  }
}
