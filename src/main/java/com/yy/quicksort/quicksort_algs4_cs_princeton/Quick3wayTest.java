package com.yy.quicksort.quicksort_algs4_cs_princeton;

import org.junit.Test;

public class Quick3wayTest {

    @Test
    public void sort() {
        Quick3way.sort(new Integer[]{1,1,0,0,2,3});
    }

    @Test
    public void sort1() {
        Quick3way.sort(new Integer[]{1,1,4,5,6,6,0,0,2,3});
    }
}