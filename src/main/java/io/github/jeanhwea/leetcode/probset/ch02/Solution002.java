package io.github.jeanhwea.leetcode.probset.ch02;

/**
 * 两数相加
 *
 * @author Jinghui Hu
 * @since 2021-06-07, JDK1.8
 */
@SuppressWarnings("all")
public class Solution002 {

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode p = l1, q = l2, head = null, tail = null;

    int carry = 0;
    while (p != null || q != null) {
      carry += (p != null ? p.val : 0) + (q != null ? q.val : 0);
      ListNode r = p != null ? p : q;
      r.val = carry % 10;
      carry /= 10;
      if (head == null) {
        head = tail = r;
      } else {
        tail = tail.next = r;
      }
      p = p != null ? p.next : null;
      q = q != null ? q.next : null;
    }

    if (carry > 0) {
      ListNode r = new ListNode(carry);
      if (head == null) {
        head = tail = r;
      } else {
        tail = tail.next = r;
      }
    }

    tail.next = null;
    return head;
  }

  public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode p = l1, q = l2, head = null, tail = null;

    int carry = 0;
    while (p != null && q != null) {
      carry += p.val + q.val;
      ListNode t = p;
      p.val = carry % 10;
      carry /= 10;
      if (head == null) {
        head = tail = t;
      } else {
        tail.next = t;
        tail = t;
      }
      p = p.next;
      q = q.next;
    }

    ListNode r = p != null ? p : q;

    while (r != null) {
      carry += r.val;
      r.val = carry % 10;
      carry /= 10;
      if (head == null) {
        head = tail = r;
      } else {
        tail.next = r;
        tail = r;
      }
      r = r.next;
    }

    if (carry > 0) {
      ListNode t = new ListNode(carry);
      if (head == null) {
        head = tail = t;
      } else {
        tail.next = t;
        tail = t;
      }
    }

    tail.next = null;

    return head;
  }

  public static ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
    ListNode p = l1, q = l2, h = null, t = null;
    int a = 0, b = 0, c = 0, v = 0;
    while (p != null || q != null) {
      a = p != null ? p.val : 0;
      b = q != null ? q.val : 0;
      v = (a + b + c) % 10;
      c = (a + b + c) / 10;
      if (h == null) {
        h = new ListNode(v, null);
        t = h;
      } else {
        t.next = new ListNode(v, null);
        t = t.next;
      }
      p = p != null ? p.next : null;
      q = q != null ? q.next : null;
    }
    if (c > 0) {
      t.next = new ListNode(c, null);
    }
    return h;
  }

  public static void main(String[] args) {
    ListNode l1 = ListNode.makeList(new int[] {2, 5, 9});
    ListNode l2 = ListNode.makeList(new int[] {5, 6, 4});
    ListNode.dispList(l1);
    ListNode.dispList(l2);
    ListNode ans = addTwoNumbers(l1, l2);
    System.out.println("========================================");
    ListNode.dispList(ans);
  }
}
