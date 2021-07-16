package io.github.jeanhwea.leetcode.probset.ch02_list;

import java.util.*;

/**
 * 环形链表 II
 *
 * @author Jinghui Hu
 * @since 2021-07-10, JDK1.8
 */
@SuppressWarnings("all")
public class Solution142 {

  // 距离计算法
  public static ListNode detectCycle(ListNode head) {
    ListNode p = head, q = head;

    // 查找快慢指针相遇点，如不存在返回空
    while (q != null) {
      if (q.next == null || q.next.next == null) return null;
      p = p.next;
      q = q.next.next;
      if (p == q) break;
    }

    // 相遇点到交叉点的距离就是链表头到交叉点的距离
    ListNode h = head;
    while (q != h) {
      q = q.next;
      h = h.next;
    }
    return h;
  }

  public static ListNode detectCycle0(ListNode head) {
    Map<ListNode, Integer> seen = new HashMap<>();
    ListNode p = head;
    while (p != null) {
      if (seen.containsKey(p)) return p;
      seen.put(p, 1);
      p = p.next;
    }
    return null;
  }

  public static void main(String[] args) {
    // pass
  }
}
