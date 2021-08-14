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

  // 使用层序遍历
  public static Node connect0(Node root) {
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

  // 优化空间复杂度, 利用上层已经记录好的链表结构
  public static Node connect(Node root) {
    if (root == null) return null;
    Node head = root;
    while (head != null) {
      Node p = head, prev = null, curr = null;
      head = null;
      while (p != null) {
        if (p.left != null) {
          curr = p.left;
          if (prev == null) head = curr;
          if (prev != null) prev.next = curr;
          prev = curr;
        }
        if (p.right != null) {
          curr = p.right;
          if (prev == null) head = curr;
          if (prev != null) prev.next = curr;
          prev = curr;
        }
        p = p.next;
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
