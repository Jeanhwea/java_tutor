package io.github.jeanhwea.leetcode.probset.ch05;

import java.util.*;

/**
 * 二叉树的层序遍历
 *
 * @author Jinghui Hu
 * @since 2021-07-13, JDK1.8
 */
@SuppressWarnings("all")
public class Solution102 {

  public static List<List<Integer>> levelOrder(TreeNode root) {
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
      ans.add(values);
    }

    return ans;
  }

  public static void main(String[] args) {
    TreeNode tree01 = TreeNode.makeTree(new int[] {1, 2, 3, 4, 5});
    TreeNode.dispTree(tree01);
    List<List<Integer>> res = levelOrder(tree01);
    System.out.println(res);
  }
}
