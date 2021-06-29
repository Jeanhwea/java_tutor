package io.github.jeanhwea.leetcode.basic.ch04;

/**
 * 删除链表中的节点
 *
 * @author Jinghui Hu
 * @since 2021-06-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution237 {

  public static void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.makeList(new int[] {1, 2, 3, 4, 5});
    ListNode node = head.next;
    ListNode.dispList(head);
    deleteNode(node);
    ListNode.dispList(head);
  }
}
