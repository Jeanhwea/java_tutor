package io.github.jeanhwea.leetcode.probset.ch02_list;

/**
 * 分隔链表
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution086 {

  public static ListNode partition(ListNode head, int x) {
    ListNode p, h1, t1, h2, t2;
    p = head;
    h1 = t1 = new ListNode(-1);
    h2 = t2 = new ListNode(-1);
    while (p != null) {
      if (p.val < x) {
        t1 = t1.next = p;
        p = p.next;
        t1.next = null;
      } else {
        t2 = t2.next = p;
        p = p.next;
        t2.next = null;
      }
    }

    t1.next = h2.next;
    return h1.next;
  }

  public static void main(String[] args) {
    ListNode list01 = ListNode.makeList(new int[] {1, 4, 3, 2, 5, 2});
    partition(list01, 3);
    ListNode.dispList(list01);
  }
}
