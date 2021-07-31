package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 路径总和
 *
 * @author Jinghui Hu
 * @since 2021-08-01, JDK1.8
 */
@SuppressWarnings("all")
public class Solution112 {

  public static boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;

    Deque<TreeNode> stack = new LinkedList<>();
    Deque<Integer> sumStack = new LinkedList<>();
    stack.push(root);
    sumStack.push(root.val);
    while (!stack.isEmpty()) {
      TreeNode p = stack.pop();
      int currSum = sumStack.pop();
      if (p.left == null && p.right == null && currSum == targetSum) return true;

      if (p.right != null) {
        stack.push(p.right);
        sumStack.push(currSum + p.right.val);
      }
      if (p.left != null) {
        stack.push(p.left);
        sumStack.push(currSum + p.left.val);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    // pass
  }
}
