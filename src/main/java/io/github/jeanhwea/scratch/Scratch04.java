package io.github.jeanhwea.scratch;

import java.util.*;

/**
 * 链表
 *
 * @author Jinghui Hu
 * @since 2021-06-11, JDK1.8
 */
public class Scratch04 {

  ////////////////////////////////////////////////////////////////////////////////
  // 链表的大小
  public static int listSize(ListNode head) {
    int n = 0;
    while (head != null) {
      n++;
      head = head.next;
    }
    return n;
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 插入链表
  public static ListNode insert(ListNode head, int k, int val) {
    ListNode p = null;
    for (int i = 0; i < k - 1; i++) {
      p = p != null ? p.next : head;
    }

    ListNode q = new ListNode(val);
    if (p == null) {
      q.next = head;
      head = q;
    } else {
      q.next = p.next;
      p.next = q;
    }

    return head;
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 删除链表
  public static ListNode remove(ListNode head, int k) {
    ListNode p = null;
    for (int i = 0; i < k - 1; i++) {
      p = p != null ? p.next : head;
    }

    if (p == null) {
      head = head.next;
    } else {
      p.next = p.next.next;
    }

    return head;
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 反转链表
  public static ListNode reverse(ListNode head) {
    return null;
  }

  public static void main(String args[]) {
    ListNode head = ListNode.makeList(new int[] {1, 2, 3, 4, 5, 6, 7});
    ListNode.display(head);
    System.out.println("========================================");
    System.out.println(listSize(head));
    ListNode.display(remove(head, 7));
  }
}
