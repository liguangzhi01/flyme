package com.lgz.flyme.design.behavioral.chainresponsibility;

/**
 * @author liguangzhi
 * @date 2020/09/17 10:43
 */
public class TrimHanler implements Handler{

    @Override
    public void doHandle(String subject) {
        System.out.println("TrimHandler");
    }
}
