package com.lgz.flyme.design.structural.proxy;

import java.lang.reflect.Proxy;

/**
 * @author liguangzhi
 * @date 2020/11/13
 */
public class Test01 {

    /**
     *
     * 动态代理中所说的"动态",是针对使用Java代码实际编写了代理类的"静态"代理而言的,
     * 它的优势不在于省去了编写代理类那一点编码工作量,
     * 而是实现了可以在原始类和接口还未知的时候,就确定了代理类的行为,
     * 当代理类与原始类脱离直接联系后,就可以很灵活的重用于不同的应用场景之中
     *
     *
     *
     *
     * 装饰和代理都有着相似的结构，这两个模式的构建都基于组合，
     * 也就是说一个对象将部分工作委派给另外一个对象，两者之间的不同在于，代理通常是自己管理服务对象的生命周期，
     * 而装饰的生成总是由客户端进行控制。
     *
     */

    public static void main(String[] args) {
        Colour colour = new Red();
        DynamicProxyHandler handler = new DynamicProxyHandler(colour);
        Colour proxyInstance = (Colour)Proxy.newProxyInstance(colour.getClass().getClassLoader(), colour.getClass().getInterfaces(), handler);
        proxyInstance.show();
    }
}
