package io.github.jeanhwea.leetcode.misc;

import java.util.*;

/**
 * 路径求和 II
 *
 * @author Jinghui Hu
 * @since 2021-06-14, JDK1.8
 */
public class Solution113 {

  public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> ans = new LinkedList<>();

    if (root == null) return ans;

    Stack<TreeNode> nodes = new Stack<>();
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Map<TreeNode, Integer> sum = new HashMap<>();
    nodes.push(root);
    parent.put(root, null);
    sum.put(root, root.val);
    while (!nodes.isEmpty()) {
      TreeNode p = nodes.pop();
      if (p.left == null && p.right == null && sum.get(p) == targetSum) {
        List<Integer> path = new LinkedList<>();
        TreeNode q = p;
        while (q != null) {
          path.add(q.val);
          q = parent.get(q);
        }
        Collections.reverse(path);
        ans.add(path);
      }

      int s = sum.getOrDefault(p, 0);
      if (p.left != null) {
        nodes.add(p.left);
        sum.put(p.left, s + p.left.val);
        parent.put(p.left, p);
      }
      if (p.right != null) {
        nodes.add(p.right);
        sum.put(p.right, s + p.right.val);
        parent.put(p.right, p);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    TreeNode tree1 =
        TreeNode.makeTree(new int[] {5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, -1, 5, 1});
    int targetSum = 22;
    TreeNode.display(tree1);
    List<List<Integer>> ans = pathSum(tree1, targetSum);
    System.out.println(ans.toString());
  }
}
