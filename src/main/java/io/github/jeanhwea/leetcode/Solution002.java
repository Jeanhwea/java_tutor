package io.github.jeanhwea.leetcode;

import java.util.*;

public class Solution002 {

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode p = l1, q = l2, h = null, t = null;
    int a = 0, b = 0, c = 0, v = 0;
    while (p != null || q != null) {
      a = p != null ? p.val : 0;
      b = q != null ? q.val : 0;
      v = (a + b + c) % 10;
      c = (a + b + c) / 10;
      if (h == null) {
        h = new ListNode(v, null);
        t = h;
      } else {
        t.next = new ListNode(v, null);
        t = t.next;
      }
      p = p != null ? p.next : null;
      q = q != null ? q.next : null;
    }
    if (c > 0) {
      t.next = new ListNode(c, null);
    }
    return h;
  }

  public static void main(String args[]) {
    ListNode l1 = makeList(new int[] {2, 3, 4});
    ListNode l2 = makeList(new int[] {5, 6, 4});
    ListNode ans = addTwoNumbers(l1, l2);
    System.out.println(listToString(l1));
    System.out.println(listToString(l2));
    System.out.println("========================================");
    System.out.println(listToString(ans));
  }

  public static ListNode makeList(int[] a) {
    ListNode h = null, t = null;
    for (int i = 0; i < a.length; i++) {
      if (h == null) {
        h = new ListNode(a[i], null);
        t = h;
      } else {
        t.next = new ListNode(a[i], null);
        t = t.next;
      }
    }
    return h;
  }

  public static String listToString(ListNode h) {
    ListNode t = h;
    if (t == null) {
      return "[]";
    }

    String result = "";
    while (t != null) {
      result += Integer.toString(t.val) + ", ";
      t = t.next;
    }
    return "[" + result.substring(0, result.length() - 2) + "]";
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
