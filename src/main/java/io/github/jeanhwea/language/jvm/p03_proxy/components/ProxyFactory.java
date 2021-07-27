package io.github.jeanhwea.language.jvm.p03_proxy.components;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * <li>实现 InvocationHandler接口的类作为代理对象的生产工厂
 * <li>持有被代理对象 target, 来在 invoke()方法 中对被代理对象的目标方法进行调用和增强
 *
 * @author Jinghui Hu
 * @since 2021-07-27, JDK1.8
 */
public class ProxyFactory implements InvocationHandler {
  private Object target = null;

  public Object getInstance(Object target) {
    this.target = target;
    return Proxy.newProxyInstance(
        target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object result = null;
    System.out.println("ProxyFactory#Before#invoke()");
    result = method.invoke(target, args);
    System.out.println("ProxyFactory#After#invoke()");
    return result;
  }
}
