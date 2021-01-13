package com.lgz.flyme.design.behavioral.strategy;

/**
 * @author liguangzhi
 * @date 2020/09/17 14:00
 */
public class SorterRange {

    private Long min;
    private Long max;
    private FileSorter sorter;

    public SorterRange(Long min, Long max, FileSorter sorter) {
        this.min = min;
        this.max = max;
        this.sorter = sorter;
    }


    public boolean inRange(Long size) {

        if( size >= min && size < max) {
            return true;
        }
        return false;

    }

    public FileSorter getSorter() {
        return sorter;
    }
}
