package io.github.jeanhwea.leetcode.basic.ch03;

import java.util.*;

/**
 * 反转链表
 *
 * @author Jinghui Hu
 * @since 2021-06-11, JDK1.8
 */
public class Solution206 {

  public static ListNode reverseList(ListNode head) {
    ListNode p = head, q = head;

    while (p != null) {
      if (p == head) {
        p = p.next;
        head.next = null;
      } else {
        q = head;
        head = p;
        p = p.next;
        head.next = q;
      }
    }

    return head;
  }

  public static void main(String args[]) {
    ListNode head = ListNode.makeList(new int[] {1, 2, 3, 4, 5});
    ListNode.display(head);
    System.out.println("========================================");
    head = reverseList(head);
    ListNode.display(head);
  }
}
