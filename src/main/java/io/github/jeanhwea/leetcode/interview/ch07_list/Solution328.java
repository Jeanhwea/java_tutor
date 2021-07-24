package io.github.jeanhwea.leetcode.interview.ch07_list;

/**
 * 奇偶链表
 *
 * @author Jinghui Hu
 * @since 2021-06-19, JDK1.8
 */
@SuppressWarnings("all")
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
    ListNode.dispList(list1);
    ListNode.dispList(oddEvenList(list1));
    ListNode list2 = ListNode.makeList(new int[] {1, 2, 3, 4, 5});
    ListNode.dispList(list2);
    ListNode.dispList(oddEvenList(list2));
    ListNode list3 = ListNode.makeList(new int[] {});
    ListNode.dispList(list3);
    ListNode.dispList(oddEvenList(list3));
    ListNode list4 = ListNode.makeList(new int[] {1, 2});
    ListNode.dispList(list4);
    ListNode.dispList(oddEvenList(list4));
  }
}
