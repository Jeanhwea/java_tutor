package io.github.jeanhwea.leetcode.interview.ch09;

import java.util.*;

/**
 * 二叉树的最近公共祖先
 *
 * @author Jinghui Hu
 * @since 2021-06-15, JDK1.8
 */
@SuppressWarnings("all")
public class Solution236 {

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;

    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Deque<TreeNode> nodes = new LinkedList<>();
    nodes.push(root);
    parent.put(root, null);
    while (!nodes.isEmpty()) {
      TreeNode c = nodes.pop();
      if (parent.containsKey(p) && parent.containsKey(q)) break;
      if (c.left != null) {
        parent.put(c.left, c);
        nodes.push(c.left);
      }
      if (c.right != null) {
        parent.put(c.right, c);
        nodes.push(c.right);
      }
    }

    Set<TreeNode> seen = new HashSet<>();
    while (p != null) {
      seen.add(p);
      p = parent.get(p);
    }
    while (q != null) {
      if (seen.contains(q)) return q;
      q = parent.get(q);
    }

    return null;
  }

  public static void main(String[] args) {
    TreeNode tree1 = TreeNode.makeTree(new int[] {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4});
    TreeNode.dispTree(tree1);
    TreeNode p = findOneNode(tree1, 5);
    TreeNode q = findOneNode(tree1, 1);
    TreeNode ans = lowestCommonAncestor(tree1, p, q);
    System.out.println(ans.val);
  }

  private static TreeNode findOneNode(TreeNode root, int val) {
    if (root == null) return null;
    if (root.val == val) return root;
    TreeNode p = findOneNode(root.left, val);
    TreeNode q = findOneNode(root.right, val);
    return p == null ? q : p;
  }
}
