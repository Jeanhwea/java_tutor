package io.github.jeanhwea.leetcode.interview.ch07;

import java.util.*;

/**
 * 奇偶链表
 *
 * @author Jinghui Hu
 * @since 2021-06-19, JDK1.8
 */
public class Solution328 {

  public static ListNode oddEvenList0(ListNode head) {
    ListNode p = head, h1 = null, h2 = null, t1 = null, t2 = null;
    while (p != null) {
      if (h1 == null) {
        t1 = h1 = p;
      } else {
        t1 = t1.next = p;
      }
      if (h2 == null) {
        t2 = h2 = p.next;
      } else {
        t2 = t2.next = p.next;
      }
      p = p.next != null ? p.next.next : null;
    }

    if (t1 != null) t1.next = h2;
    if (t2 != null) t2.next = null;

    return head;
  }

  public static ListNode oddEvenList(ListNode head) {
    ListNode head2, p, q;
    p = head;
    head2 = q = null;
    while (p != null && p.next != null) {
      if (head2 == null) {
        q = head2 = p.next;
        continue;
      }

      if (p.next.next == null) break;

      p.next = q.next;
      p = p.next;
      q.next = p.next;
      q = q.next;
    }

    if (p != null) p.next = head2;
    if (q != null) q.next = null;
    return head;
  }

  public static void main(String[] args) {
    ListNode list1 = ListNode.makeList(new int[] {1, 2, 3, 4, 5, 6});
    ListNode.display(list1);
    ListNode.display(oddEvenList(list1));
    ListNode list2 = ListNode.makeList(new int[] {1, 2, 3, 4, 5});
    ListNode.display(list2);
    ListNode.display(oddEvenList(list2));
    ListNode list3 = ListNode.makeList(new int[] {});
    ListNode.display(list3);
    ListNode.display(oddEvenList(list3));
    ListNode list4 = ListNode.makeList(new int[] {1, 2});
    ListNode.display(list4);
    ListNode.display(oddEvenList(list4));
  }
}
