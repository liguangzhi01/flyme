package com.lgz.flyme.design.behavioral.chainresponsibility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liguangzhi
 * @date 2020/09/17 10:44
 */
public class TestChain {


    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        List<Handler> handlerList = new ArrayList<>();
        handlerList.add(new TrimHanler());
        handlerList.add(new UpperCaseHandler());
        String str = "  sss   ";
        handlerChain.setHandlerList(handlerList);
        handlerChain.doHandle(str);

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

        LinkedList<Object> objects = new LinkedList<>();

        new LinkedBlockingQueue<>();
        Thread thread = new Thread();
    }

}
