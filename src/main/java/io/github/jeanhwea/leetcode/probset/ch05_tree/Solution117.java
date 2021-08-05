package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * @author Jinghui Hu
 * @since 2021-08-05, JDK1.8
 */
@SuppressWarnings("all")
public class Solution117 {

  public static Node connect(Node root) {
    return null;
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
