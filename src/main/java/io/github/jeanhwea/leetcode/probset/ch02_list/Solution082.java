package io.github.jeanhwea.leetcode.probset.ch02_list;

/**
 * 删除排序链表中的重复元素 II
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution082 {

  public static ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode p = dummy;
    while (p != null) {
      ListNode q = p.next;
      while (q != null && q.next != null && q.val == q.next.val) {
        q = q.next;
      }
      if (q != p.next) {
        p.next = q.next;
      } else {
        p = p.next;
      }
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode list01 = ListNode.makeList(new int[] {1, 2, 3, 3, 4, 4, 5, 5});
    ListNode.dispList(deleteDuplicates(list01));
  }
}
