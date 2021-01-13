package com.lgz.flyme.design.behavioral.strategy;

import com.lgz.flyme.design.behavioral.strategy.impl.BigFileSorter;
import com.lgz.flyme.design.behavioral.strategy.impl.LittleFileSorter;
import com.lgz.flyme.design.behavioral.strategy.impl.MiddleFileSorter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liguangzhi
 * @date 2020/09/17 13:47
 */
public class FileSorterStrategy {


    private static final List<SorterRange> list = new ArrayList<>();

    static {
        list.add(new SorterRange(0L, 50L, new LittleFileSorter()));
        list.add(new SorterRange(50L, 100L, new MiddleFileSorter()));
        list.add(new SorterRange(100L, Long.MAX_VALUE, new BigFileSorter()));
    }


    public static void sort(File file) {

        FileSorter fileSorter = null;
        for (SorterRange sorterRange : list) {
            if (sorterRange.inRange(file.length())) {
                fileSorter = sorterRange.getSorter();
                break;
            }
        }
        if(fileSorter == null) {
            throw new RuntimeException("can not find appropriate file sort strategy");
        }
        fileSorter.sort(file);
    }
}
