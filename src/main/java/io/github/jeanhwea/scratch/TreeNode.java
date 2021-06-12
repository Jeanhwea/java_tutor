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
    int n = a.length, depth = 1, s = 0;

    Queue<TreeNode> nodes = new LinkedList<>();
    TreeNode root = new TreeNode(a[0]), p = null;
    nodes.offer(root);
    while (Math.pow(2, depth - 1) < n) {
      for (int i = 0; i < Math.pow(2, depth - 1); i++) {
        p = nodes.poll();
        if (p == null) continue;

        s = 2 * i + (int) Math.pow(2, depth - 1);
        if (s < n && a[s] > 0) {
          p.left = new TreeNode(a[s]);
          nodes.offer(p.left);
        } else {
          nodes.offer(null);
        }

        s++;
        if (s < n && a[s] > 0) {
          p.right = new TreeNode(a[s]);
          nodes.offer(p.right);
        } else {
          nodes.offer(null);
        }
      }
      depth++;
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

  public static void main(String args[]) {
    // TreeNode root = makeTree(new int[] {1, 2, 3, 4, 5});
    TreeNode tree4 = makeTree(new int[] {1, 2, 3, -1, 4, 5, 6, -1, -1, 7});
    // display(root);
    // System.out.println("====");
  }
}
