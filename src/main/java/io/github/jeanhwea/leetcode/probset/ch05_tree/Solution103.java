package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 *
 * @author Jinghui Hu
 * @since 2021-07-13, JDK1.8
 */
@SuppressWarnings("all")
public class Solution103 {

  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new LinkedList<>();
    if (root == null) return ans;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int depth = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> values = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (depth % 2 == 0) {
          values.add(node.val);
        } else {
          values.add(0, node.val);
        }
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
      ans.add(values);
      ++depth;
    }

    return ans;
  }

  public static void main(String[] args) {
    TreeNode tree01 = TreeNode.makeTree(new int[] {1, 2, 3, 4, 5});
    TreeNode.dispTree(tree01);
    List<List<Integer>> res = zigzagLevelOrder(tree01);
    System.out.println(res);
  }
}
