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

  public static void display(TreeNode root) {
    if (root == null) {
      System.out.println("null");
    }

    List<Integer> vals = new LinkedList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (true) {
      int size = queue.size();
      boolean done = true;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (null == node) {
          vals.add(-1);
          continue;
        } else {
          vals.add(node.val);
        }

        if (null == node.left) {
          queue.offer(null);
        } else {
          queue.offer(node.left);
          done = false;
        }

        if (null == node.right) {
          queue.offer(null);
        } else {
          queue.offer(node.right);
          done = false;
        }
      }
      if (done) break;
    }

    System.out.println(Arrays.toString(vals.toArray()));
  }
}
