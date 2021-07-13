package io.github.jeanhwea.realworld;

import java.util.*;

/**
 * 实现一个单向链表的操作
 *
 * @author Jinghui Hu
 * @since 2021-07-13, JDK1.8
 */
@SuppressWarnings("all")
public class Problem0713 {

  public static class MyList<T> {

    private static class Node<T> {
      T val;
      Node<T> next;

      public Node(T val) {
        this.val = val;
      }
    }

    private final Node<T> dummy;

    public MyList() {
      this.dummy = new Node<T>(null);
    }

    public void insert(T val) {
      Node<T> p = new Node<T>(val);
      p.next = dummy.next;
      dummy.next = p;
    }

    public void reverse() {
      Node<T> p = dummy.next;
      dummy.next = null;
      while (p != null) {
        Node<T> t = dummy.next;
        dummy.next = p;
        p = p.next;
        dummy.next.next = t;
      }
    }

    public void print() {
      Node<T> p = dummy.next;
      StringBuilder sb = new StringBuilder();
      sb.append("[");
      while (p != null) {
        sb.append(String.valueOf(p.val));
        sb.append(", ");
        p = p.next;
      }
      sb.delete(sb.length() - 2, sb.length());
      sb.append("]");
      System.out.println(sb.toString());
    }
  }

  public static void main(String[] args) {
    MyList<Integer> list01 = new MyList<>();
    list01.insert(3);
    list01.insert(2);
    list01.insert(1);
    list01.print();
    list01.reverse();
    System.out.println("----------------------------------------");
    list01.print();

    MyList<String> list02 = new MyList<>();
    list02.insert("A");
    list02.insert("B");
    list02.insert("C");
    list02.print();
    list02.reverse();
    System.out.println("----------------------------------------");
    list02.print();
  }
}
