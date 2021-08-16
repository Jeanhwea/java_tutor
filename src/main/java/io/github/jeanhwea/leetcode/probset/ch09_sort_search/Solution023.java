package io.github.jeanhwea.leetcode.probset.ch09_sort_search;

import java.util.*;

/**
 * 合并 K 个升序链表
 *
 * @author Jinghui Hu
 * @since 2021-08-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution023 {

  public static ListNode mergeKLists(ListNode[] lists) {
    return mergeList(lists, 0, lists.length);
  }

  private static ListNode mergeList(ListNode[] lists, int beg, int end) {
    // 边界条件
    if (beg > lists.length - 1) return null;
    if (beg >= end) return lists[beg];

    // 分治法, 将数组分成两个部分处理
    int mid = beg + (end - beg) / 2;
    ListNode p = mergeList(lists, beg, mid);
    ListNode q = mergeList(lists, mid + 1, end);

    // 合并链表
    ListNode dummy = new ListNode(-1), t = dummy;
    while (p != null && q != null) {
      if (p.val < q.val) {
        t.next = p;
        p = p.next;
        t = t.next;
        t.next = null;
      } else {
        t.next = q;
        q = q.next;
        t = t.next;
        t.next = null;
      }
    }
    t.next = p != null ? p : q;
    return dummy.next;
  }

  public static void main(String[] args) {
    List<ListNode> lists = new LinkedList<>();
    lists.add(ListNode.makeList(new int[] {1, 4, 5}));
    lists.add(ListNode.makeList(new int[] {1, 3, 4}));
    lists.add(ListNode.makeList(new int[] {2, 6}));
    ListNode[] arr = new ListNode[lists.size()];
    for (int i = 0; i < lists.size(); i++) {
      arr[i] = lists.get(i);
    }
    ListNode res = mergeKLists(arr);
    ListNode.dispList(res);
  }
}
