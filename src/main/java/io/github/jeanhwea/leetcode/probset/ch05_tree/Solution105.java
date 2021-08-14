package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author Jinghui Hu
 * @since 2021-07-16, JDK1.8
 */
@SuppressWarnings("all")
public class Solution105 {

  // 辅助栈
  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0) return null;
    TreeNode root = new TreeNode(preorder[0]);
    // stack 记录当前节点还未考虑右儿子节点
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.push(root);
    int j = 0;
    for (int i = 1; i < preorder.length; i++) {
      TreeNode node = stack.peek(); // 栈顶元素是上次新建的节点
      if (node.val != inorder[j]) {
        node.left = new TreeNode(preorder[i]);
        stack.push(node.left);
      } else {
        // 中序遍历刚好和 stack 里面的元素顺序相反, 同时出栈和中序数组下标右移
        while (!stack.isEmpty() && stack.peek().val == inorder[j]) {
          node = stack.pop();
          j++;
        }
        node.right = new TreeNode(preorder[i]);
        stack.push(node.right);
      }
    }
    return root;
  }

  // 递归法
  public static TreeNode buildTree1(int[] preorder, int[] inorder) {
    return helper(preorder, inorder, 0, 0, preorder.length);
  }

  public static TreeNode helper(int[] preorder, int[] inorder, int x, int y, int len) {
    if (len <= 0) return null;

    TreeNode root = new TreeNode(preorder[x]);

    int i = y;
    while (i < y + len && inorder[i] != root.val) i++;

    root.left = helper(preorder, inorder, x + 1, y, i - y);
    root.right = helper(preorder, inorder, x + 1 + i - y, i + 1, len - (i - y) - 1);
    return root;
  }

  public static void main(String[] args) {
    int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
    TreeNode tree01 = buildTree1(preorder, inorder);
    TreeNode.dispTree(tree01);
  }
}
