package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 二叉树的后序遍历
 *
 * @author Jinghui Hu
 * @since 2021-07-13, JDK1.8
 */
@SuppressWarnings("all")
public class Solution145 {

  public static List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ans = new LinkedList<>();
    if (root == null) return ans;

    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode prev = null;
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.peek();
      if (root.right == null || root.right == prev) {
        ans.add(root.val);
        prev = stack.pop();
        root = null;
      } else {
        root = root.right;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    TreeNode tree01 = TreeNode.makeTree(new int[] {1, 2, 3, 4, 5});
    TreeNode.dispTree(tree01);
    List<Integer> res = postorderTraversal(tree01);
    System.out.println(res);
  }
}
