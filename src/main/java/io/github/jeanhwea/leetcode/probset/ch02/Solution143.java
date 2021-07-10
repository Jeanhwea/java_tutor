package io.github.jeanhwea.leetcode.probset.ch02;

import java.util.*;

/**
 * 重排链表
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution143 {

  public static void reorderList(ListNode head) {
    // 快慢指针将链表划分
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // 链表拆分，后半部分需要逆序
    ListNode dummy = new ListNode(-1);
    ListNode p = slow, q = null;
    while (p != null) {
      q = dummy.next;
      dummy.next = p;
      p = p.next;
      dummy.next.next = q;
    }

    // 合并两个链表
    p = head;
    q = dummy.next;
    while (p != null && q != null) {
      ListNode t = p.next;
      p.next = q;
      q = q.next;
      p.next.next = t;
      p = t;
    }
  }

  public static void reorderList0(ListNode head) {
    // 计算链表大小
    int n = 0;
    ListNode p = head, q = null;
    while (p != null) {
      n++;
      p = p.next;
    }

    // 链表拆分，前半部分不需要倒序
    p = head;
    int i = 0;
    while (++i <= n / 2) p = p.next;
    q = p;
    p = p.next;
    q.next = null;

    // 链表拆分，后半部分需要逆序
    ListNode dummy = new ListNode(-1);
    while (p != null) {
      q = dummy.next;
      dummy.next = p;
      p = p.next;
      dummy.next.next = q;
    }

    // 合并两个链表
    p = head;
    q = dummy.next;
    while (p != null && q != null) {
      ListNode t = p.next;
      p.next = q;
      q = q.next;
      p.next.next = t;
      p = t;
    }
  }

  public static void main(String[] args) {
    ListNode list01 = ListNode.makeList(new int[] {1, 2, 3, 4});
    reorderList(list01);
    ListNode.dispList(list01);
  }
}
