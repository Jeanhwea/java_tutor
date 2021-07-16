package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 二叉树的中序遍历
 *
 * @author Jinghui Hu
 * @since 2021-07-13, JDK1.8
 */
@SuppressWarnings("all")
public class Solution094 {

  public static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new LinkedList<>();
    if (root == null) return ans;

    Deque<TreeNode> stack = new LinkedList<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      ans.add(root.val);
      root = root.right;
    }

    return ans;
  }

  public static void main(String[] args) {
    TreeNode tree01 = TreeNode.makeTree(new int[] {1, 2, 3, 4, 5});
    TreeNode.dispTree(tree01);
    List<Integer> res = inorderTraversal(tree01);
    System.out.println(res);
  }
}
