package io.github.jeanhwea.leetcode;

import java.util.*;

public class Solution {


  public static void main(String args[]) {
    ListNode p = makeList(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
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
