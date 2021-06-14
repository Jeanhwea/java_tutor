package io.github.jeanhwea.leetcode.interview.ch05;

import java.util.*;

/**
 * 排序链表
 *
 * @author Jinghui Hu
 * @since 2021-06-14, JDK1.8
 */
public class Solution148 {

  // TODO 添加归并排序
  public static ListNode sortList1(ListNode head) {
    return head;
  }

  // 插排
  public static ListNode sortList0(ListNode head) {
    ListNode q = head;
    while (q != null) {
      if (q == head) {
        q = q.next;
        head.next = null;
      } else {
        ListNode p = head;
        if (q.val < head.val) {
          head = q;
          q = q.next;
          head.next = p;
        } else {
          while (p.next != null && p.next.val < q.val) {
            p = p.next;
          }
          ListNode t = p.next;
          p.next = q;
          q = q.next;
          p.next.next = t;
        }
      }
    }
    return head;
  }

  public static ListNode sortList(ListNode head) {
    int n = 0;
    ListNode p = head;
    while (p != null) {
      p = p.next;
      n++;
    }

    int[] a = new int[n];
    int i = 0;
    p = head;
    while (p != null) {
      a[i++] = p.val;
      p = p.next;
    }

    Arrays.sort(a);
    i = 0;
    p = head;
    while (p != null) {
      p.val = a[i++];
      p = p.next;
    }

    return head;
  }

  public static void main(String args[]) {
    ListNode list1 = ListNode.makeList(new int[] {4, 2, 1, 3});
    ListNode.display(list1);
    list1 = sortList(list1);
    ListNode.display(list1);
  }
}
