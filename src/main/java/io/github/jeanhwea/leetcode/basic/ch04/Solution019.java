package io.github.jeanhwea.leetcode.basic.ch04;

/**
 * 删除链表的倒数第 N 个节点
 *
 * @author Jinghui Hu
 * @since 2021-06-11, JDK1.8
 */
public class Solution019 {

  public static ListNode removeNthFromEnd(ListNode head, int k) {
    ListNode p = head;
    int n = 0;
    while (p != null) {
      n++;
      p = p.next;
    }

    if (n == k) return head.next;

    p = head;
    int i = n - k - 1;
    while (i > 0) {
      p = p.next;
      i--;
    }

    p.next = p.next.next;

    return head;
  }

  public static void main(String args[]) {
    // ListNode head = ListNode.makeList(new int[] {1, 2, 3, 4});
    for (int i = 1; i <= 4; i++) {
      ListNode head = ListNode.makeList(new int[] {1, 2, 3, 4});
      // ListNode.display(head);
      ListNode.display(removeNthFromEnd(head, i));
    }
  }
}
