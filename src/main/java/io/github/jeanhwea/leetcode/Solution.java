package io.github.jeanhwea.leetcode;

import java.util.*;

public class Solution {

  public static ListNode reverseRange(ListNode head, int m, int n) {
    ListNode p = head, q = head;
    for (int i = 0; i < n - 1; i++) {
      if (i < m - 2) p = p.next;
      q = q.next;
    }
    // System.out.println(q.val);

    ListNode t = p;
    t = p.next;
    p.next = q;

    // while (t != q) {
    //   t = p.next;
    //   p.next = t.next;
    //   t.next = p.next;
    //   p.next = t;
    //   p = p.next;
    // }

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
    int[] a = {1, 2, 3, 4};
    ListNode p = makeList(a);
    display(p);
    ListNode p1 = reverse(p);
    display(p1);
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
