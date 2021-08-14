package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 填充每个节点的下一个右侧节点指针 II
 *
 * @author Jinghui Hu
 * @since 2021-08-05, JDK1.8
 */
@SuppressWarnings("all")
public class Solution117 {

  public static Node connect(Node root) {
    if (root == null) return null;
    Deque<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      Node prev = null;
      for (int i = 0; i < size; i++) {
        Node curr = queue.poll();
        if (curr.left != null) queue.offer(curr.left);
        if (curr.right != null) queue.offer(curr.right);
        if (prev != null) prev.next = curr;
        prev = curr;
      }
    }
    return root;
  }

  public static void main(String[] args) {
    //
  }

  static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  };
}
