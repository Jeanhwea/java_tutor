package io.github.jeanhwea.leetcode.probset.ch02_list;

/**
 * 删除排序链表中的重复元素
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution083 {

  public static ListNode deleteDuplicates(ListNode head) {
    ListNode p = head;
    while (p != null) {
      if (p.next != null && p.next.val == p.val) {
        p.next = p.next.next;
      } else {
        p = p.next;
      }
    }
    return head;
  }

  public static ListNode deleteDuplicates0(ListNode head) {
    ListNode p = head, q = null;
    while (p != null) {
      if (q == null) {
        q = p;
        p = p.next;
        q.next = null;
      } else if (p.val != q.val) {
        q.next = p;
        q = q.next;
        p = p.next;
        q.next = null;
      } else {
        p = p.next;
      }
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode list01 = ListNode.makeList(new int[] {1, 1, 2});
    ListNode.dispList(deleteDuplicates(list01));
    // ListNode.dispList(deleteDuplicates(null));
  }
}
