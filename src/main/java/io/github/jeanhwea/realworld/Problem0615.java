package io.github.jeanhwea.realworld;

import java.util.*;

/**
 * 判断一个二叉树是否为平衡二叉树
 *
 * @author Jinghui Hu
 * @since 2021-07-01, JDK1.8
 */
@SuppressWarnings("all")
public class Problem0615 {

  public static class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  private static Map<TreeNode, Integer> height = new HashMap<>();

  public static boolean isAvlTree(TreeNode root) {
    if (root == null) return true;
    isAvlTree(root.left);
    isAvlTree(root.right);

    int x = height.getOrDefault(root.left, 0);
    int y = height.getOrDefault(root.right, 0);

    height.put(root, Math.max(x, y) + 1);
    return Math.abs(x - y) == 1;
  }

  public static boolean isAvlTree2(TreeNode root) {
    Map<TreeNode, Integer> nodeHeight = new HashMap<>();

    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode prev = null;

    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }

      root = stack.peek();
      if (root.right == null || root.right == prev) {

        // working
        int x = nodeHeight.getOrDefault(root.left, 0);
        int y = nodeHeight.getOrDefault(root.right, 0);
        if (Math.abs(x - y) > 1) {
          System.out.println(nodeHeight);
          return false;
        }
        int h = Math.max(x, y) + 1;
        nodeHeight.put(root, h);

        root = null;
        prev = stack.pop();
      } else {
        root = root.right;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    root.left = node1;
    root.right = node2;
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    node1.left = node3;
    node1.right = node4;
    TreeNode node5 = new TreeNode(5);
    node3.left = node5;

    System.out.println(isAvlTree(root));
    System.out.println(isAvlTree2(root));
  }
}
