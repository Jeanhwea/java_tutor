package io.github.jeanhwea.leetcode.probset.ch02_list;

/**
 * 删除链表的倒数第 N 个结点
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution019 {

  // 快慢指针
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode fast, slow;
    fast = slow = dummy;
    while (n-- >= 0) fast = fast.next;

    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    if (slow != null && slow.next != null) {
      slow.next = slow.next.next;
    }

    return dummy.next;
  }

  // 计算链表长度
  public static ListNode removeNthFromEnd0(ListNode head, int n) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    int size = 0;
    ListNode p = dummy;
    while (p != null) {
      p = p.next;
      ++size;
    }

    int k = size - n;
    p = dummy;
    while (--k > 0) p = p.next;

    if (p != null && p.next != null) p.next = p.next.next;

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode list01 = ListNode.makeList(new int[] {1, 2, 3, 4, 5});
    ListNode.dispList(removeNthFromEnd(list01, 5));
    // ListNode list01 = ListNode.makeList(new int[] {1});
    // ListNode.dispList(removeNthFromEnd(list01, 1));
  }
}
