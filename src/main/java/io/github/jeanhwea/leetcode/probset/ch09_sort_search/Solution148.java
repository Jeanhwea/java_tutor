package io.github.jeanhwea.leetcode.probset.ch09_sort_search;

import java.util.*;

/**
 * 排序链表
 *
 * @author Jinghui Hu
 * @since 2021-08-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution148 {

  ////////////////////////////////////////////////////////////////////////////////
  public static ListNode sortList(ListNode head) {
    return mergeSort(head, null);
  }

  // 归并排序 [beg, end]
  private static ListNode mergeSort(ListNode beg, ListNode end) {
    if (beg == end) return beg;

    ListNode fast = beg, slow = beg;
    while (fast != end && fast.next != end) {
      fast = fast.next.next;
      slow = slow.next;
    }

    ListNode a = mergeSort(slow.next, end);
    slow.next = null;
    ListNode b = mergeSort(beg, slow);

    ListNode dummy = new ListNode(-1), p = dummy;
    while (a != null && b != null) {
      if (a.val < b.val) {
        p.next = a;
        a = a.next;
        p = p.next;
        p.next = null;
      } else {
        p.next = b;
        b = b.next;
        p = p.next;
        p.next = null;
      }
    }
    p.next = a != null ? a : b;

    return dummy.next;
  }

  ////////////////////////////////////////////////////////////////////////////////
  public static ListNode sortList0(ListNode head) {
    return quickSort(head);
  }

  // 快速排序
  private static ListNode quickSort(ListNode head) {
    // 边界条件
    if (head == null || head.next == null) return head;

    // 三路拆分, 小于部分 small, 等于部分 same, 大于部分 great
    int pivot = head.val;
    ListNode same = new ListNode(-1);
    ListNode small = new ListNode(-1);
    ListNode great = new ListNode(-1);

    while (head != null) {
      if (head.val < pivot) {
        head = addFirst(small, head);
      } else if (head.val > pivot) {
        head = addFirst(great, head);
      } else {
        head = addFirst(same, head);
      }
    }

    // 分治排序, 快速排序子链表
    ListNode left = quickSort(small.next);
    ListNode right = quickSort(great.next);

    // 三路归并
    ListNode dummy = new ListNode(-1), p = dummy;
    p.next = left;
    while (p.next != null) p = p.next;
    p.next = same.next;
    while (p.next != null) p = p.next;
    p.next = right;

    return dummy.next;
  }

  private static ListNode addFirst(ListNode hair, ListNode p) {
    ListNode q = p.next;
    p.next = hair.next;
    hair.next = p;
    return q;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.makeList(new int[] {1, 3, 8, 9, 11, 4, 5});
    ListNode res = sortList(head);
    // ListNode res = quickSort(head);
    ListNode.dispList(res);
  }
}
