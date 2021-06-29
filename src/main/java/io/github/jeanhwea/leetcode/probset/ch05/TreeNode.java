package io.github.jeanhwea.leetcode.probset.ch05;

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
    int n = a.length;
    if (a.length < 1) return null;

    Queue<TreeNode> nodes = new LinkedList<>();
    TreeNode root = new TreeNode(a[0]), p = null;
    nodes.offer(root);

    int depth = 1;
    while (true) {
      int size = 1 << depth;
      if (n < size) break;

      for (int i = 0; i < size / 2; i++) {
        p = nodes.poll();
        if (p == null) {
          nodes.offer(null);
          nodes.offer(null);
        } else {
          int s = 2 * i + size - 1;
          if (s < n) {
            if (a[s] >= 0) {
              p.left = new TreeNode(a[s]);
              nodes.offer(p.left);
            } else {
              nodes.offer(null);
            }
          } else break;

          s++;
          if (s < n) {
            if (a[s] >= 0) {
              p.right = new TreeNode(a[s]);
              nodes.offer(p.right);
            } else {
              nodes.offer(null);
            }
          } else break;
        }
      }

      depth++;
    }

    return root;
  }

  public static void dispTree(TreeNode root) {
    if (root == null) {
      System.out.println("null");
      return;
    }

    List<Integer> values = new ArrayList<>();
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.offer(root);
    values.add(root.val);

    int depth = 1;
    while (true) {
      int size = 1 << depth;
      boolean done = true;
      for (int i = 0; i < size / 2; i++) {
        TreeNode p = nodes.poll();
        if (p == null) {
          nodes.offer(null);
          nodes.offer(null);
          values.add(-1);
          values.add(-1);
        } else {
          if (p.left != null) {
            nodes.offer(p.left);
            values.add(p.left.val);
            done = false;
          } else {
            nodes.offer(null);
            values.add(-1);
          }

          if (p.right != null) {
            nodes.offer(p.right);
            values.add(p.right.val);
            done = false;
          } else {
            nodes.offer(null);
            values.add(-1);
          }
        }
      }
      if (done) break;
      depth++;
    }

    int k = values.size() - 1;
    while (k >= 0) {
      if (values.get(k) >= 0) break;
      k--;
    }
    values = values.subList(0, k + 1);

    System.out.println(values);
  }
}
