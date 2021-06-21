package io.github.jeanhwea;

import java.util.*;

public class App {

  public static void main(String[] args) {
    ClassLoader loader = ClassLoader.getSystemClassLoader();
    System.out.println(loader); // => sun.misc.Launcher$AppClassLoader@73d16e93
    System.out.println(loader.getParent()); // => sun.misc.Launcher$ExtClassLoader@15db9742
    System.out.println(loader.getParent().getParent()); // => null
    System.out.println("Hello World!");
  }
}
