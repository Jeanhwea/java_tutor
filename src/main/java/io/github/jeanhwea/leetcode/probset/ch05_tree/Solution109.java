package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 有序链表转换二叉搜索树
 *
 * @author Jinghui Hu
 * @since 2021-08-15, JDK1.8
 */
@SuppressWarnings("all")
public class Solution109 {

  public TreeNode sortedListToBST(ListNode head) {
    return createTree(head, null);
  }

  // 构造 [beg, end) 区间的二叉搜索树
  private TreeNode createTree(ListNode beg, ListNode end) {
    if (beg == end) return null;

    ListNode slow = beg, fast = beg;
    while (fast != end && fast.next != end) {
      slow = slow.next;
      fast = fast.next.next;
    }

    TreeNode root = new TreeNode(slow.val);
    root.left = createTree(beg, slow);
    root.right = createTree(slow.next, end);
    return root;
  }

  public static void main(String[] args) {
    //
  }
}
