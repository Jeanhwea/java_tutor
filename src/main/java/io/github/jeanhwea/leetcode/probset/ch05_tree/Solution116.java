package io.github.jeanhwea.leetcode.probset.ch05_tree;

/**
 * 填充每个节点的下一个右侧节点指针
 *
 * @author Jinghui Hu
 * @since 2021-08-14, JDK1.8
 */
@SuppressWarnings("all")
public class Solution116 {

  // 优化空间复杂度, 利用上层已经记录好的链表结构
  public static Node connect(Node root) {
    if (root == null) return null;
    Node head = root;
    while (head.left != null) {
      Node p = head, prev = null;
      while (p != null) {
        if (prev != null) prev.right.next = p.left;
        p.left.next = p.right;
        prev = p;
        p = p.next;
      }
      head = head.left;
    }
    return root;
  }

  public static void main(String[] args) {
    // pass
  };
}
