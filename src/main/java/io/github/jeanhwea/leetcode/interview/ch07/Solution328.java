package io.github.jeanhwea.leetcode.interview.ch07;

import java.util.*;

/**
 * 奇偶链表
 *
 * @author Jinghui Hu
 * @since 2021-06-19, JDK1.8
 */
public class Solution328 {

  public static ListNode oddEvenList(ListNode head) {
    ListNode p = head, h1 = null, h2 = null, t1 = null, t2 = null;
    while (p != null) {
      ListNode q = p.next;
      if (h1 == null) {
        t1 = h1 = p;
      } else {
        t1 = t1.next = p;
      }
      if (h2 == null) {
        t2 = h2 = q;
      } else {
        t2 = t2.next = q;
      }
      p = q != null ? q.next : null;
    }

    if (t1 != null) t1.next = h2;
    if (t2 != null) t2.next = null;

    return head;
  }

  public static void main(String[] args) {
    ListNode tree1 = ListNode.makeList(new int[] {1, 2, 3, 4, 5, 6});
    ListNode.display(tree1);
    ListNode.display(oddEvenList(tree1));
    ListNode tree2 = ListNode.makeList(new int[] {1, 2, 3, 4, 5});
    ListNode.display(tree2);
    ListNode.display(oddEvenList(tree2));
  }
}
