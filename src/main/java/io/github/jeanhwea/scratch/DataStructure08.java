package io.github.jeanhwea.scratch;

import java.util.*;

/**
 * 红黑树
 * <li>1. 节点非黑即红
 * <li>2. 根节点为黑色
 * <li>3. 叶子节点为黑色（一般叶子节点为空，并省略）
 * <li>4. 相邻节点不能同为红色（红色节点的子节点为黑色）
 * <li>5. 节点 A 下的所有叶子节点到节点 A 的路径上的黑色节点数目相等
 *
 * @author Jinghui Hu
 * @since 2021-06-06, JDK1.8
 */
public class DataStructure08 {

  public static class RBTree {
    public int val;
    public boolean isRed;
    public RBTree left, right;

    public RBTree(int val, boolean isRed) {
      this.val = val;
      this.isRed = isRed;
    }

    public boolean isRed() {
      return this.isRed;
    }

    public boolean isBlack() {
      return !this.isRed;
    }
  }

  public static void main(String[] args) {
    // coding
  }
}
