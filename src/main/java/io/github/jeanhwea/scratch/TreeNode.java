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

  public static void display(TreeNode root) {
    if (root == null) {
      System.out.println("null");
    }

    List<Integer> vals = new LinkedList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (true) {}

    // System.out.println(Arrays.toString(vals.toArray()));
  }

  public static void main(String args[]) {
    // TreeNode root = makeTree(new int[] {1, 2, 3, 4, 5});
    TreeNode tree4 = makeTree(new int[] {1, 2, 3, -1, 4, 5, 6, -1, -1, 7});
    // TreeNode tree4 = makeTree(new int[] {1, 2, 3});
    display(tree4);
    // System.out.println(1 << 3);
    // display(root);
    // System.out.println("====");
  }
}
