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
  }
}
