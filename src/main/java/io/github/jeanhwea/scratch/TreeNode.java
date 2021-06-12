package io.github.jeanhwea.scratch;

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
    if (a.length < 1) return null;
    int n = a.length, m = 1, s = 0;

    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root = new TreeNode(a[0]), p = null;
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        s = 2 * i + m;
        if (s < n && a[s] >= 0) {
          p = new TreeNode(a[s]);
          node.left = p;
          queue.offer(p);
        }
        s++;
        if (s < n && a[s] >= 0) {
          p = new TreeNode(a[s]);
          node.right = p;
          queue.offer(p);
        }
        s++;
      }
      m = s;
    }

    return root;
  }

  public static void main(String args[]) {
    TreeNode root = makeTree(new int[] {1, 2, 3, 4, 5});
    System.out.println("====");
  }
}
