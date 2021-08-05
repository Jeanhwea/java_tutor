package io.github.jeanhwea.language.jvm.p02_class_loader;

import java.util.*;

/**
 * 添加类加载器
 *
 * @author Jinghui Hu
 * @since 2021-07-27, JDK1.8
 */
@SuppressWarnings("all")
public class App {

  public static void main(String[] args) {
    ClassLoader loader = ClassLoader.getSystemClassLoader();
    System.out.println(loader); // => sun.misc.Launcher$AppClassLoader@73d16e93
    System.out.println(loader.getParent()); // => sun.misc.Launcher$ExtClassLoader@15db9742
    System.out.println(loader.getParent().getParent()); // => null
  }
}
