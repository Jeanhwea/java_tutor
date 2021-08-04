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

  // 迭代的辅助前序遍历
  public static void flatten(TreeNode root) {
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

  public static void main(String[] args) {
    TreeNode root = TreeNode.makeTree(new int[] {1, 2, 5, 3, 4, -1, 6});
    TreeNode.dispTree(root);
    flatten(root);
  }
}
