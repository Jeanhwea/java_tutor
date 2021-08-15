package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 求根节点到叶节点数字之和
 *
 * @author Jinghui Hu
 * @since 2021-08-15, JDK1.8
 */
@SuppressWarnings("all")
public class Solution129 {

  public static int sumNumbers(TreeNode root) {
    int ans = 0;
    if (root == null) return ans;
    Deque<TreeNode> stack = new LinkedList<>();
    Deque<Integer> numStack = new LinkedList<>();
    stack.push(root);
    numStack.push(root.val);
    while (!stack.isEmpty()) {
      TreeNode p = stack.pop();
      int currNum = numStack.pop();
      if (p.left == null && p.right == null) {
        ans += currNum;
      }
      if (p.left != null) {
        stack.push(p.left);
        numStack.push(10 * currNum + p.left.val);
      }
      if (p.right != null) {
        stack.push(p.right);
        numStack.push(10 * currNum + p.right.val);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    // pass
  }
}
