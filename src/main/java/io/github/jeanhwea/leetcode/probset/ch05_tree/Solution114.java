package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 二叉树展开为链表
 *
 * @author Jinghui Hu
 * @since 2021-08-04, JDK1.8
 */
@SuppressWarnings("all")
public class Solution114 {

  // 辅助栈迭代前序遍历
  public static void flatten0(TreeNode root) {
    if (root == null) return;
    TreeNode tail = root;
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode curr = stack.pop();
      if (curr.right != null) stack.push(curr.right);
      if (curr.left != null) stack.push(curr.left);
      if (curr != tail) {
        tail.right = curr;
        tail = curr;
        tail.left = null;
      } else {
        curr.left = curr.right = null;
      }
    }
  }

  // 寻找前驱的解法, 参考 Morris 变量思路
  public static void flatten(TreeNode root) {
    TreeNode curr = root;
    while (curr != null) {
      if (curr.left != null) {
        TreeNode next = curr.left;
        TreeNode prev = next;
        while (prev.right != null) prev = prev.right;
        prev.right = curr.right;
        curr.left = null;
        curr.right = next;
      }
      curr = curr.right;
    }
  }

  public static void main(String[] args) {
    TreeNode root = TreeNode.makeTree(new int[] {1, 2, 5, 3, 4, -1, 6});
    TreeNode.dispTree(root);
    flatten(root);
  }
}
