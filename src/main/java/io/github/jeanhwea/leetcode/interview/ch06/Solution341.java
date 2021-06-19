package io.github.jeanhwea.leetcode.interview.ch06;

import java.util.*;

/**
 * 扁平化嵌套列表迭代器
 *
 * @author Jinghui Hu
 * @since 2021-06-19, JDK1.8
 */
public class Solution341 {

  public static class NestedIterator implements Iterator<Integer> {

    Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
      this.stack = new LinkedList<>();
      this.addIntegers(nestedList);
    }

    private void addIntegers(List<NestedInteger> list) {
      for (int i = list.size() - 1; i >= 0; i--) {
        NestedInteger v = list.get(i);
        this.stack.push(v);
      }
    }

    @Override
    public Integer next() {
      return hasNext() ? this.stack.pop().getInteger() : null;
    }

    @Override
    public boolean hasNext() {
      while (!this.stack.isEmpty()) {
        NestedInteger val = this.stack.pop();
        if (val.isInteger()) {
          this.stack.push(val);
          return true;
        } else {
          this.addIntegers(val.getList());
        }
      }
      return false;
    }
  }

  public static void main(String[] args) {
    // pass
  }
}
