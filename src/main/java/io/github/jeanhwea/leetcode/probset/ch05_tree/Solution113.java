package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 路径求和 II
 *
 * @author Jinghui Hu
 * @since 2021-06-14, JDK1.8
 */
@SuppressWarnings("all")
public class Solution113 {

  public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> ans = new LinkedList<>();
    if (root == null) return ans;
    Deque<TreeNode> stack = new LinkedList<>();
    Deque<Integer> sumStack = new LinkedList<>();
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    stack.push(root);
    sumStack.push(root.val);
    while (!stack.isEmpty()) {
      TreeNode p = stack.pop();
      int currSum = sumStack.pop();
      if (currSum == targetSum && p.left == null && p.right == null) {
        LinkedList<Integer> path = new LinkedList<>();
        TreeNode q = p;
        while (q != null) {
          path.addFirst(q.val);
          q = parent.get(q);
        }
        ans.add(path);
      }
      if (p.left != null) {
        parent.put(p.left, p);
        stack.push(p.left);
        sumStack.push(currSum + p.left.val);
      }
      if (p.right != null) {
        parent.put(p.right, p);
        stack.push(p.right);
        sumStack.push(currSum + p.right.val);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    TreeNode tree1 =
        TreeNode.makeTree(new int[] {5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, -1, 5, 1});
    int targetSum = 22;
    TreeNode.dispTree(tree1);
    List<List<Integer>> ans = pathSum(tree1, targetSum);
    System.out.println(ans.toString());
  }
}
