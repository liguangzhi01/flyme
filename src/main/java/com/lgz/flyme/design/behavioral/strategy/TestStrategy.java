package com.lgz.flyme.design.behavioral.strategy;

import java.io.File;

/**
 * @author liguangzhi
 * @date 2020/09/17 13:52
 */
public class TestStrategy {

    public static void main(String[] args) {
        File file = new File("resources/application.properties");


        FileSorterStrategy.sort(file);

    }
}
