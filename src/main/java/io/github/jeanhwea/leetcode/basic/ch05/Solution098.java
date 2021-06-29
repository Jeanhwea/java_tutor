package io.github.jeanhwea.leetcode.basic.ch05;

import java.util.*;

/**
 * 验证二叉搜索树
 *
 * @author Jinghui Hu
 * @since 2021-06-12, JDK1.8
 */
@SuppressWarnings("all")
public class Solution098 {

  public static List<Integer> trans(TreeNode root, List<Integer> list) {
    if (root == null) return list;
    List<Integer> li = trans(root.left, list);
    li.add(root.val);
    return trans(root.right, list);
  }

  public static boolean isValidBST0(TreeNode root) {
    if (root == null) return true;
    List<Integer> list = new LinkedList<>();
    List<Integer> res = trans(root, list);
    for (int i = 0; i < res.size() - 1; i++) {
      if (res.get(i) >= res.get(i + 1)) return false;
    }

    return true;
  }

  public static boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    Integer mi = null;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }

      root = stack.pop();
      // System.out.println(root.val);
      if (mi == null) {
        mi = root.val;
      } else {
        if (root.val <= mi) return false;
        mi = root.val;
      }

      root = root.right;
    }

    return true;
  }

  public static void main(String[] args) {
    TreeNode tree = TreeNode.makeTree(new int[] {5, 1, 4, -1, -1, 3, 6});
    System.out.println(isValidBST(tree));
  }
}
