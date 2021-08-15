package io.github.jeanhwea.leetcode.probset.ch06_graph;

import java.util.*;

/**
 * 克隆图
 *
 * @author Jinghui Hu
 * @since 2021-08-15, JDK1.8
 */
@SuppressWarnings("all")
public class Solution133 {

  // 缓存, 记录已经克隆的图的节点
  private static Map<Node, Node> old2new;

  public static Node cloneGraph(Node node) {
    old2new = new HashMap<>();
    return doCloneNode(node);
  }

  public static Node doCloneNode(Node node) {
    if (node == null) return null;

    Node newNode = old2new.get(node);
    if (null != newNode) return newNode;

    newNode = new Node(node.val, new ArrayList<>());
    old2new.put(node, newNode);
    for (Node oldNbr : node.neighbors) {
      Node newNbr = doCloneNode(oldNbr);
      newNode.neighbors.add(newNbr);
    }

    return newNode;
  }

  public static void main(String[] args) {
    // pass
  }

  private static class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}
