package com.lgz.flyme.design.behavioral.chainresponsibility;

import java.util.List;

/**
 * @author liguangzhi
 * @date 2020/09/17 10:39
 */
public class HandlerChain {

    private List<Handler>  handlerList;

    public HandlerChain(){}

    public HandlerChain(List<Handler>  handlerList){
        this.handlerList = handlerList;
    }

    public void doHandle(String subject) {
        for (Handler handler : handlerList) {
            handler.doHandle(subject);
        }
    }

    public void setHandlerList(List<Handler> handlerList) {
        this.handlerList = handlerList;
    }
}
