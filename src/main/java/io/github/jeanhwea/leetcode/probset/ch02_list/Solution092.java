package io.github.jeanhwea.leetcode.probset.ch02_list;

/**
 * 反转链表 II
 *
 * @author Jinghui Hu
 * @since 2021-07-09, JDK1.8
 */
@SuppressWarnings("all")
public class Solution092 {

  public static ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode p = dummy;
    int i = 0;
    while (i++ < left - 1) p = p.next;

    ListNode t1 = p;
    i++;
    p = p.next;

    ListNode h2 = null, t2 = null;
    while (p != null && i <= right + 1) {
      if (h2 == null) {
        h2 = t2 = p;
        p = p.next;
        t2.next = null;
      } else {
        ListNode t = h2;
        h2 = p;
        p = p.next;
        h2.next = t;
      }
      i++;
    }

    t1.next = h2;
    t2.next = p;

    return dummy.next;
  }

  public static void main(String[] args) {
    // ListNode head = ListNode.makeList(new int[] {1, 2, 3, 4, 5});
    // ListNode ans = reverseBetween(head, 2, 4);
    ListNode head = ListNode.makeList(new int[] {3, 5});
    ListNode ans = reverseBetween(head, 1, 2);
    ListNode.dispList(ans);
  }
}
