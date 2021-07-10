package io.github.jeanhwea.leetcode.probset.ch02;

import java.util.*;

/**
 * K 个一组翻转链表
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution025 {

  public static ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode p = dummy;
    while (p != null) {
      int i = k;
      ListNode q = p.next, h = null, t = null;
      while (--i >= 0 && q != null) {
        if (h == null) {
          h = t = q;
          q = q.next;
          t.next = null;
        } else {
          t.next = h;
          h = q;
          q = q.next;
          h.next = t.next;
          t.next = null;
        }
      }

      if (i >= 0) {
        q = h;
        while (q != null) {
          if (q == h) {
            h = t = q;
            q = q.next;
            t.next = null;
          } else {
            t.next = h;
            h = q;
            q = q.next;
            h.next = t.next;
            t.next = null;
          }
        }
      }

      if (h != null) {
        p.next = h;
        t.next = q;
      }
      p = t;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode list01 = ListNode.makeList(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
    ListNode.dispList(reverseKGroup(list01, 3));
  }
}
