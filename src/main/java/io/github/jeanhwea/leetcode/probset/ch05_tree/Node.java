package io.github.jeanhwea.leetcode.probset.ch05_tree;

/**
 * 带有 next 指针的二叉树节点
 *
 * @author Jinghui Hu
 * @since 2021-08-15, JDK1.8
 */
class Node {
  public int val;
  public Node left, right, next;

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
}
