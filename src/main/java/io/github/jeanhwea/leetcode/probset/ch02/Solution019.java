package io.github.jeanhwea.leetcode.probset.ch02;

import java.util.*;

/**
 * 删除链表的倒数第 N 个结点
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution019 {

  public static ListNode removeNthFromEnd(ListNode head, int n) {
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
    ListNode.dispList(removeNthFromEnd(list01, 2));
    // ListNode list01 = ListNode.makeList(new int[] {1});
    // ListNode.dispList(removeNthFromEnd(list01, 1));
  }
}
