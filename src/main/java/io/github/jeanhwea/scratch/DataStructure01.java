package io.github.jeanhwea.scratch;

import java.util.*;

/**
 * 链表
 *
 * @author Jinghui Hu
 * @since 2021-06-11, JDK1.8
 */
public class DataStructure01 {

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
    ListNode p = head;
    while (p != null) {
      if (p == head) {
        p = p.next;
        head.next = null;
      } else {
        ListNode t = head;
        head = p;
        p = p.next;
        head.next = t;
      }
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode list0 = null;
    ListNode list1 = ListNode.makeList(new int[] {1});
    ListNode list2 = ListNode.makeList(new int[] {1, 2});
    ListNode list3 = ListNode.makeList(new int[] {1, 2, 3, 4, 5, 6, 7});
    ListNode.display(list1);
    System.out.println("========================================");
    // System.out.println(listSize(list1));
    // ListNode.display(remove(list1, 7));
    ListNode.display(reverse(list0));
    ListNode.display(reverse(list2));
  }
}
