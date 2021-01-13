package com.lgz.flyme.design.behavioral.strategy.impl;

import com.lgz.flyme.design.behavioral.strategy.FileSorter;

import java.io.File;

/**
 * @author liguangzhi
 * @date 2020/09/17 13:46
 */
public class BigFileSorter implements FileSorter {
    @Override
    public void sort(File file) {
        System.out.println("BigFileSorter");
    }
}
