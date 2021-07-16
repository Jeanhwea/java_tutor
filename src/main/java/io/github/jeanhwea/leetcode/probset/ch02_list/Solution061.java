package io.github.jeanhwea.leetcode.probset.ch02_list;

/**
 * 旋转链表
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution061 {

  public static ListNode rotateRight(ListNode head, int k) {
    if (head == null) return null;

    ListNode p = head;
    int n = 1;
    while (p != null && p.next != null) {
      n++;
      p = p.next;
    }
    p.next = head;

    int i = (n - k % n);
    p = head;
    while (--i > 0) p = p.next;
    head = p.next;
    p.next = null;

    return head;
  }

  public static ListNode rotateRight0(ListNode head, int k) {
    if (head == null) return null;

    ListNode p = head, tail = null;

    int n = 0;
    while (p != null && p.next != null) {
      n++;
      p = p.next;
    }
    tail = p;
    n++;

    k %= n;
    p = head;
    for (int i = 1; i < n - k; i++) {
      p = p.next;
    }
    tail.next = head;
    head = p.next;
    p.next = null;

    return head;
  }

  public static void main(String[] args) {
    ListNode list01 = ListNode.makeList(new int[] {1, 2, 3, 4, 5});
    ListNode.dispList(rotateRight(list01, 4));
  }
}
