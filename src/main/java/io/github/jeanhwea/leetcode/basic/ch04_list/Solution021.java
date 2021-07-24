package io.github.jeanhwea.leetcode.basic.ch04_list;

/**
 * 合并两个有序链表
 *
 * @author Jinghui Hu
 * @since 2021-06-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution021 {

  /**
   * 递归版本
   *
   * @author Jinghui Hu
   * @since 2021-06-11, JDK1.8
   */
  public static ListNode mergeTwoLists(ListNode p, ListNode q) {
    if (p == null) return q;
    else if (q == null) return p;
    else if (p.val < q.val) {
      p.next = mergeTwoLists(p.next, q);
      return p;
    } else {
      q.next = mergeTwoLists(p, q.next);
      return q;
    }
  }

  /**
   * 迭代版本
   *
   * @author Jinghui Hu
   * @since 2021-06-11, JDK1.8
   */
  public static ListNode mergeTwoLists0(ListNode p, ListNode q) {
    if (p == null) return q;
    if (q == null) return p;

    ListNode head, t, s;
    head = t = s = null;
    while (p != null && q != null) {
      if (p.val < q.val) {
        s = p;
        p = p.next;
      } else {
        s = q;
        q = q.next;
      }

      if (head == null) {
        head = t = s;
        t.next = null;
      } else {
        t.next = s;
        t = s;
        t.next = null;
      }
    }

    t.next = p == null ? q : p;

    return head;
  }

  public static void main(String[] args) {
    ListNode p = ListNode.makeList(new int[] {1, 2, 3, 3, 4});
    ListNode q = ListNode.makeList(new int[] {1, 1, 2, 3, 3, 4});
    ListNode head = mergeTwoLists(p, q);
    ListNode.dispList(head);
  }
}
