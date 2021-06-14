package io.github.jeanhwea.leetcode.misc;

import java.util.*;

/**
 * 两数相加
 *
 * @author Jinghui Hu
 * @since 2021-06-07, JDK1.8
 */
public class Solution002 {

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode p = l1, q = l2, h = null, t = null;
    int a = 0, b = 0, c = 0, v = 0;
    while (p != null || q != null) {
      a = p != null ? p.val : 0;
      b = q != null ? q.val : 0;
      v = (a + b + c) % 10;
      c = (a + b + c) / 10;
      if (h == null) {
        h = new ListNode(v, null);
        t = h;
      } else {
        t.next = new ListNode(v, null);
        t = t.next;
      }
      p = p != null ? p.next : null;
      q = q != null ? q.next : null;
    }
    if (c > 0) {
      t.next = new ListNode(c, null);
    }
    return h;
  }

  public static void main(String args[]) {
    ListNode l1 = ListNode.makeList(new int[] {2, 3, 4});
    ListNode l2 = ListNode.makeList(new int[] {5, 6, 4});
    ListNode ans = addTwoNumbers(l1, l2);
    ListNode.display(l1);
    ListNode.display(l2);
    System.out.println("========================================");
    ListNode.display(ans);
  }
}
