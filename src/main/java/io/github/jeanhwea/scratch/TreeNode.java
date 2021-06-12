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
    if (a.length<1) return null;

    Queue<TreeNode> queue = LinkedList<>();
    TreeNode root = new TreeNode(a[0]);
    queue.offer(queue);
    while(!queue.isEmpty()) {
      TreeNode node =
    }

    return root;
  }

  public static void main(String args[]) {
    TreeNode root = makeTree(new int[] {1, 2, 3, 4, 5});
    System.out.println("====");
  }
}
