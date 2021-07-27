package io.github.jeanhwea.language.jvm.p03_proxy.components.impl;

import io.github.jeanhwea.language.jvm.p03_proxy.components.Adder;

/**
 * 实现简单累加方法
 *
 * @author Jinghui Hu
 * @since 2021-07-27, JDK1.8
 */
public class AdderImpl implements Adder {
  @Override
  public int add(int a, int b) {
    return a + b;
  }
}
