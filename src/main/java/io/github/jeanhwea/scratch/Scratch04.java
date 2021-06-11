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

  public static ListNode reverse(ListNode head) {
    ListNode p = head, h = null, q;

    while (p != null) {
      if (h == null) {
        h = p;
        p = p.next;
        h.next = null;
      } else {
        q = h;
        h = p;
        p = p.next;
        h.next = q;
      }
    }

    return h;
  }

  public static void main(String args[]) {
    ListNode p = makeList(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
    display(p);
    display(reverseRange(p, 1, 3));
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

  public static void display(ListNode head) {
    List<Integer> vals = new LinkedList<Integer>();
    ListNode p = head;
    while (p != null) {
      vals.add(p.val);
      p = p.next;
    }
    display(vals);
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

  public static class ListNode {
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
  }
}
