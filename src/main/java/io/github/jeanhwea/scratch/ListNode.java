package io.github.jeanhwea.scratch;

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
    ListNode head = null, p = null;
    for (int i = 0; i < a.length; i++) {
      ListNode t = new ListNode(a[i], null);
      if (head == null) {
        head = p = t;
      } else {
        p = p.next = t;
      }
    }
    return head;
  }

  public static void display(ListNode head) {
    List<Integer> vals = new LinkedList<Integer>();
    ListNode p = head;
    while (p != null) {
      vals.add(p.val);
      p = p.next;
    }
    System.out.println(Arrays.toString(vals.toArray()));
  }
}
