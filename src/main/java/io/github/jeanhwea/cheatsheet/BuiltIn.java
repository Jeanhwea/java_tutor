package io.github.jeanhwea.cheatsheet;

import java.util.*;

/**
 * @author Jinghui Hu
 * @since 2021-06-20, JDK1.8
 */
public class BuiltIn {

  public static void arrayIntro() {
    // 定义数组
    int[] arr1 = new int[10];
    int[] arr2 = {1, 2, 3, 4};
    // System.out.println(Arrays.toString(arr2));

    Arrays.fill(arr1, 1); // 填充数组
    // System.out.println(Arrays.toString(arr1));

    // 数组复制
    int[] arr3 = Arrays.copyOf(arr2, arr2.length);
    int[] arr4 = Arrays.copyOfRange(arr2, 2, 3); // => [3]
    // System.out.println(Arrays.toString(arr4));

    // 变长数组
    List<Integer> vector1 = new ArrayList<Integer>();
    vector1.add(1); // 添加元素到数组最后
    vector1.add(3);
    vector1.get(0); // 获取第 0 个元素
    vector1.size(); // 数组的长度
    // System.out.println(vector1);
    vector1.add(0, 8); // 添加到数组的第 0 个元素
    // System.out.println(vector1);
    vector1.set(1, 4); // 修改数组的第 1 个元素
    // System.out.println(vector1);
    vector1.remove(1); // 删除第 1 个元素
    // System.out.println(vector1);
  }

  public static void main(String[] args) {
    arrayIntro();
  }
}
