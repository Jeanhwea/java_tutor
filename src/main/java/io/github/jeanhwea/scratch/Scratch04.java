package io.github.jeanhwea.scratch;

import java.util.*;

/**
 * 链表
 *
 * @author Jinghui Hu
 * @since 2021-06-11, JDK1.8
 */
public class Scratch04 {

  public static ListNode reverseRange(ListNode head, int m, int n) {
    ListNode p = head, q = null, t = null, s = null;
    for (int i = 0; i < n; i++) {
      if (i < m - 1) {
        q = p;
        p = p != null ? p.next : null;
      } else if (i < m) {
        t = p;
        p = p.next;
      } else {
        if (q == null) {
          s = head;
          head = p;
          p = p.next;
          head.next = s;
        } else {
          s = q.next;
          q.next = p;
          p = p.next;
          q.next.next = s;
        }
      }
    }

    if (t != null) t.next = p;

    return head;
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 反转链表
  public static ListNode reverse(ListNode head) {
    ListNode p = head, q;

    while (p != null) {
      if (p == head) {
        p = p.next;
        head.next = null;
      } else {
        q = head;
        head = p;
        p = p.next;
        head.next = q;
      }
    }

    return head;
  }

  public static ListNode removeNthFromEnd(ListNode head, int k) {
    int n = 0;
    ListNode p = head;
    while (p != null) {
      n++;
      p = p.next;
    }
    // System.out.println(n);

    p = head;
    for (int i = 0; i < n - k - 1; i++) p = p.next;

    if (k == n) {
      head = head.next;
    } else {
      p.next = p.next.next;
    }

    return head;
  }

  public static void main(String args[]) {
    ListNode head = ListNode.makeList(new int[] {1, 2, 3, 4});
    ListNode.display(head);
    ListNode.display(removeNthFromEnd(head, 1));
  }

  ////////////////////////////////////////////////////////////////////////////////
  public static int[] genArray(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = (int) (Math.random() * 50);
    }
    return a;
  }

  public static void display(int[] a) {
    System.out.println(Arrays.toString(a));
  }

  public static void display(Collection<Integer> a) {
    System.out.println(Arrays.toString(a.toArray()));
  }
}
