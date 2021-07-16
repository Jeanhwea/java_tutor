package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 二叉树的层序遍历 II
 *
 * @author Jinghui Hu
 * @since 2021-07-13, JDK1.8
 */
@SuppressWarnings("all")
public class Solution107 {

  public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> ans = new LinkedList<>();
    if (root == null) return ans;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> values = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        values.add(node.val);
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
      ans.add(0, values);
    }

    return ans;
  }

  public static void main(String[] args) {
    TreeNode tree01 = TreeNode.makeTree(new int[] {1, 2, 3, 4, 5});
    TreeNode.dispTree(tree01);
    List<List<Integer>> res = levelOrderBottom(tree01);
    System.out.println(res);
  }
}
