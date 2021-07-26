package io.github.jeanhwea.language.jdk.p03_list;

import java.util.*;

/**
 * 链表实现
 *
 * @author Jinghui Hu
 * @since 2021-07-26, JDK1.8
 */
@SuppressWarnings("all")
public class MyList {

  // 链表节点定义
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }

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
    ListNode list1 = makeList(new int[] {1});
    ListNode list2 = makeList(new int[] {1, 2});
    ListNode list3 = makeList(new int[] {1, 2, 3, 4, 5, 6, 7});
    dispList(list1);
    System.out.println("========================================");
    dispList(reverse(list0));
    dispList(reverse(list2));
  }

  ////////////////////////////////////////////////////////////////////////////////
  public static ListNode makeList(int[] a) {
    ListNode head = null, tail = null;
    for (int i = 0; i < a.length; i++) {
      ListNode node = new ListNode(a[i]);
      if (head == null) {
        head = tail = node;
      } else {
        tail = tail.next = node;
      }
    }
    return head;
  }

  public static void dispList(ListNode head) {
    if (head == null) {
      System.out.println("null");
      return;
    }

    List<Integer> vals = new LinkedList<Integer>();
    ListNode tail = head;
    while (tail != null) {
      vals.add(tail.val);
      tail = tail.next;
    }
    System.out.println(Arrays.toString(vals.toArray()));
  }
}
