package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 二叉树的前序遍历
 *
 * @author Jinghui Hu
 * @since 2021-07-06, JDK1.8
 */
@SuppressWarnings("all")
public class Solution144 {

  public static List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new LinkedList<>();
    if (root == null) return ans;

    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode p = stack.pop();
      ans.add(p.val);
      if (p.right != null) stack.push(p.right);
      if (p.left != null) stack.push(p.left);
    }

    return ans;
  }

  public static void main(String[] args) {
    // pass
  }
}
