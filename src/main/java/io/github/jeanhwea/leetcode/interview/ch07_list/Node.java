package io.github.jeanhwea.leetcode.interview.ch07_list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 链表节点（带随机指针）
 *
 * @author Jinghui Hu
 * @since 2021-06-11, JDK1.8
 */
public class Node {
  int val;
  Node next, random;

  Node() {}

  Node(int val) {
    this.val = val;
  }

  Node(int val, Node next) {
    this.val = val;
    this.next = next;
  }

  public static Node makeList(int[] a) {
    Node head = null, tail = null;
    for (int i = 0; i < a.length; i++) {
      Node node = new Node(a[i], null);
      if (head == null) {
        head = tail = node;
      } else {
        tail = tail.next = node;
      }
    }
    return head;
  }

  public static void display(Node head) {
    if (head == null) {
      System.out.println("null");
      return;
    }

    List<Integer> vals = new LinkedList<Integer>();
    Node tail = head;
    while (tail != null) {
      vals.add(tail.val);
      tail = tail.next;
    }
    System.out.println(Arrays.toString(vals.toArray()));
  }

  public static void main(String[] args) {
    Node head = makeList(new int[] {1, 2, 3, 4});
    display(head);
  }
}
