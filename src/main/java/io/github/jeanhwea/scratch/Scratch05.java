package io.github.jeanhwea.scratch;

import java.util.*;

/**
 * 二叉树
 *
 * @author Jinghui Hu
 * @since 2021-06-12, JDK1.8
 */
public class Scratch05 {

  ////////////////////////////////////////////////////////////////////////////////
  // 递归求树的深度
  public static int depth(TreeNode root) {
    if (root == null) return 0;
    return Math.max(depth(root.left), depth(root.right)) + 1;
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 层序变量求数的深度
  public static int depth2(TreeNode root) {
    if (root == null) return 0;

    int depth = 0;

    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.offer(root);
    while (!nodes.isEmpty()) {
      int n = nodes.size();
      for (int i = 0; i < n; i++) {
        TreeNode p = nodes.poll();
        if (p.left != null) nodes.offer(p.left);
        if (p.right != null) nodes.offer(p.right);
      }
      depth++;
    }

    return depth;
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 二叉树前序遍历
  public static List<Integer> preorder(TreeNode root) {
    if (root == null) return new LinkedList<>();

    List<Integer> values = new LinkedList<>();
    values.add(root.val);
    if (root.left != null) values.addAll(preorder(root.left));
    if (root.right != null) values.addAll(preorder(root.right));

    return values;
  }

  public static List<Integer> preorder1(TreeNode root) {
    if (root == null) return new LinkedList<>();

    List<Integer> values = new LinkedList<>();
    Stack<TreeNode> nodes = new Stack<>();
    nodes.push(root);
    while (!nodes.isEmpty()) {
      TreeNode p = nodes.pop();
      values.add(p.val);
      if (p.right != null) nodes.add(p.right);
      if (p.left != null) nodes.add(p.left);
    }

    return values;
  }

  public static void main(String args[]) {
    List<TreeNode> trees = new LinkedList<>();
    TreeNode tree1 = null;
    TreeNode tree2 = TreeNode.makeTree(new int[] {1});
    TreeNode tree3 = TreeNode.makeTree(new int[] {1, 2, 3, 4, 5});
    TreeNode tree4 = TreeNode.makeTree(new int[] {1, 2, 3, -1, 4, 5, 6, -1, -1, 7});
    TreeNode tree5 = TreeNode.makeTree(new int[] {1, 2, 3, 4});
    trees.add(tree1);
    trees.add(tree2);
    trees.add(tree3);
    trees.add(tree4);
    trees.add(tree5);

    System.out.println("===== tree list =====");
    for (TreeNode t : trees) {
      TreeNode.display(t);
    }

    System.out.println("===== tree depth =====");
    for (TreeNode t : trees) {
      String out = String.format("depth = %d, depth2 = %d", depth(t), depth2(t));
      System.out.println(out);
    }

    System.out.println("===== Pre-Order =====");
    for (TreeNode t : trees) {
      List<Integer> v0 = preorder(t);
      System.out.println(Arrays.toString(v0.toArray()));
      List<Integer> v1 = preorder1(t);
      System.out.println(Arrays.toString(v1.toArray()));
    }
  }
}
