package io.github.jeanhwea.leetcode.probset.ch02_list;

/**
 * 两两交换链表中的节点
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution024 {

  public static ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode p = dummy;
    while (p != null && p.next != null && p.next.next != null) {
      ListNode q = p.next;
      p.next = q.next;
      q.next = p.next.next;
      p.next.next = q;
      p = q;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode list01 = ListNode.makeList(new int[] {1, 2, 3, 4});
    ListNode.dispList(swapPairs(list01));
  }
}
