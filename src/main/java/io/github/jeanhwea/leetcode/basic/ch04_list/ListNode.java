package io.github.jeanhwea.leetcode.basic.ch04_list;

import java.util.*;

/**
 * 链表节点
 *
 * @author Jinghui Hu
 * @since 2021-06-11, JDK1.8
 */
public class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode makeList(int[] a) {
    ListNode head = null, tail = null;
    for (int i = 0; i < a.length; i++) {
      ListNode node = new ListNode(a[i], null);
      if (head == null) {
        head = tail = node;
      } else {
        tail = tail.next = node;
      }
    }
    return head;
  }

  public static void dispList(ListNode head) {
    List<Integer> vals = new LinkedList<Integer>();
    ListNode tail = head;
    while (tail != null) {
      vals.add(tail.val);
      tail = tail.next;
    }
    System.out.println(Arrays.toString(vals.toArray()));
  }
}
