package io.github.jeanhwea.language.jvm.p03_proxy;

import io.github.jeanhwea.language.jvm.p03_proxy.components.Adder;
import io.github.jeanhwea.language.jvm.p03_proxy.components.ProxyFactory;
import io.github.jeanhwea.language.jvm.p03_proxy.components.impl.AdderImpl;
import java.util.*;

/**
 * JDK 动态代理
 *
 * @author Jinghui Hu
 * @since 2021-07-27, JDK1.8
 */
@SuppressWarnings("all")
public class App03 {

  public static void main(String[] args) {
    Adder adder = new AdderImpl();
    ProxyFactory proxyFactory = new ProxyFactory();
    Adder proxyedObj = (Adder) proxyFactory.getInstance(adder);
    int ans = proxyedObj.add(1, 2);
    System.out.println(ans);
  }
}
