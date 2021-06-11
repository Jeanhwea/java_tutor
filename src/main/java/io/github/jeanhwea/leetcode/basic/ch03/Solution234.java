package io.github.jeanhwea.leetcode.basic.ch03;

import java.util.*;

/**
 * 回文链表
 *
 * @author Jinghui Hu
 * @since 2021-06-11, JDK1.8
 */
public class Solution234 {

  public static ListNode reverseList(ListNode head) {
    ListNode p, q;
    p = q = head;
    while (p != null) {
      if (p == head) {
        p = p.next;
        head.next = null;
      } else {
        head = p;
        p = p.next;
        head.next = q;
        q = head;
      }
    }
    return head;
  }

  public static boolean isPalindrome(ListNode head) {
    int n = 0;
    ListNode p = head;
    while (p != null) {
      n++;
      p = p.next;
    }

    if (n <= 1) return true;

    p = head;
    for (int i = 1; i < (n + 1) / 2; i++) p = p.next;
    // ListNode.display(p);

    ListNode q = head, t = reverseList(p);
    while (q != null && t != null) {
      if (q.val != t.val) return false;
      q = q.next;
      t = t.next;
    }

    return true;
  }

  public static void main(String args[]) {
    ListNode p = ListNode.makeList(new int[] {1, 2, 2, 1});
    // ListNode.display(p);
    System.out.println(isPalindrome(p));
  }
}
