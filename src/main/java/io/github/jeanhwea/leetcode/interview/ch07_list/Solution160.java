package io.github.jeanhwea.leetcode.interview.ch07_list;

import java.util.*;

/**
 * 相交链表
 *
 * @author Jinghui Hu
 * @since 2021-06-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution160 {

  // 记忆所经过的节点
  public ListNode getIntersectionNode(ListNode p, ListNode q) {
    Set<ListNode> st = new HashSet<>();
    while (p != null) {
      st.add(p);
      p = p.next;
    }
    while (q != null) {
      if (st.contains(q)) return q;
      q = q.next;
    }
    return null;
  }

  // O(1) 复杂度：链表移动次数相同都为 a+b+c
  public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;

    ListNode p = headA, q = headB;
    while (p != q) {
      p = p == null ? headB : p.next;
      q = q == null ? headA : q.next;
    }
    return p;
  }

  public static void main(String[] args) {
    // pass
  }
}
