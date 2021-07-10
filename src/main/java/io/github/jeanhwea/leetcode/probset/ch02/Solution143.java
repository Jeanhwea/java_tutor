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
    ListNode dummy1 = new ListNode(-1), dummy2 = new ListNode(-1);
  }

  public static void main(String[] args) {
    ListNode list01 = ListNode.makeList(new int[] {1, 2, 3, 4});
    ListNode.dispList(reorderList(list01));
  }
}
