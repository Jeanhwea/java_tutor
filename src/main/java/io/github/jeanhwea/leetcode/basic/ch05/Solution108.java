package io.github.jeanhwea.leetcode.basic.ch05;

import java.util.*;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution108 {

  public static TreeNode sortedArrayToBST(int[] a) {
    int n = a.length;
    if (n <= 0) return null;

    // 构造一颗满二叉树
    Queue<TreeNode> nodes = new LinkedList<>();
    TreeNode root = new TreeNode();
    nodes.offer(root);
    int k = 1;
    while (k < n && !nodes.isEmpty()) {
      int s = nodes.size();
      for (int i = 0; i < s; i++) {
        TreeNode p = nodes.poll();
        if (k < n) {
          p.left = new TreeNode();
          nodes.offer(p.left);
          k++;
        } else break;
        if (k < n) {
          p.right = new TreeNode();
          nodes.offer(p.right);
          k++;
        } else break;
      }
    }

    // 中序遍历填数
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    k = 0;
    while (p != null || !stack.isEmpty()) {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      p = stack.pop();
      p.val = a[k++];
      p = p.right;
    }

    return root;
  }

  public static TreeNode sortedArrayToBST1(int[] a) {
    int n = a.length;
    if (n <= 0) return null;

    int p = n / 2;
    TreeNode root = new TreeNode(a[p]);
    root.left = sortedArrayToBST(Arrays.copyOfRange(a, 0, p));
    root.right = sortedArrayToBST(Arrays.copyOfRange(a, p + 1, n));

    return root;
  }

  public static void main(String[] args) {
    // int[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
    int[] nums = {1, 2};
    TreeNode tree1 = sortedArrayToBST(nums);
    TreeNode.display(tree1);
  }
}
