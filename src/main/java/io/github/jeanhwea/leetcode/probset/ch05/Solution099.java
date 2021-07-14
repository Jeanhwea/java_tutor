package io.github.jeanhwea.leetcode.probset.ch05;

import java.util.*;

/**
 * 恢复二叉搜索树
 *
 * @author Jinghui Hu
 * @since 2021-07-13, JDK1.8
 */
@SuppressWarnings("all")
public class Solution099 {

  public static void recoverTree(TreeNode root) {
    if (root == null) return;

    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode p = root;
    TreeNode prev1 = null;
    while (p != null || !stack.isEmpty()) {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      p = stack.pop();
      if (prev1 != null && p.val < prev1.val) break;
      prev1 = p;
      p = p.right;
    }

    stack.clear();
    p = root;
    TreeNode prev2 = null;
    while (p != null || !stack.isEmpty()) {
      while (p != null) {
        stack.push(p);
        p = p.right;
      }
      p = stack.pop();
      if (prev2 != null && p.val > prev2.val) break;
      prev2 = p;
      p = p.left;
    }

    int t = prev1.val;
    prev1.val = prev2.val;
    prev2.val = t;
  }

  public static void main(String[] args) {
    TreeNode tree01 = TreeNode.makeTree(new int[] {1, -1, 3, -1, -1, -1, 2});
    TreeNode.dispTree(tree01);
    recoverTree(tree01);
    TreeNode.dispTree(tree01);
  }
}
