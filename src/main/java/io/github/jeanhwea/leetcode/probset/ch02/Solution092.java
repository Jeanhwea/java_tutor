package io.github.jeanhwea.leetcode.probset.ch02;

import java.util.*;

/**
 * 反转链表 II
 *
 * @author Jinghui Hu
 * @since 2021-07-09, JDK1.8
 */
@SuppressWarnings("all")
public class Solution092 {

  public static ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode t1, h2, t2;
    t1 = h2 = t2 = null;

    ListNode p = head;
    int i = 1;
    while (i <= right + 1) {
      if (i < left - 1) {
        p = p.next;
      } else if (i < left) {
        t1 = p;
        p = p.next;
      } else if (i == left) {
        t2 = h2 = p;
        p = p.next;
        t2.next = null;
      } else if (i <= right) {
        ListNode t = h2;
        h2 = p;
        p = p.next;
        h2.next = t;
      } else {
        if (t1 == null) {
          head = h2;
        } else {
          t1.next = h2;
        }
        t2.next = p;
      }
      i++;
    }

    return head;
  }

  public static void main(String[] args) {
    // ListNode head = ListNode.makeList(new int[] {1, 2, 3, 4, 5});
    // ListNode ans = reverseBetween(head, 2, 4);
    ListNode head = ListNode.makeList(new int[] {3, 5});
    ListNode ans = reverseBetween(head, 1, 2);
    ListNode.dispList(ans);
  }
}
