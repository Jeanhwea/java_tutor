package io.github.jeanhwea.leetcode.probset.ch02;

import java.util.*;

/**
 * 反转链表 II
 *
 * @author Jinghui Hu
 * @since 2021-07-09, JDK1.8
 */
@SuppressWarnings("all")
public class Solution092 {

  public static ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode p;
  }

  public static void main(String[] args) {
    // ListNode head = ListNode.makeList(new int[] {1, 2, 3, 4, 5});
    // ListNode ans = reverseBetween(head, 2, 4);
    ListNode head = ListNode.makeList(new int[] {3, 5});
    ListNode ans = reverseBetween(head, 1, 2);
    ListNode.dispList(ans);
  }
}
