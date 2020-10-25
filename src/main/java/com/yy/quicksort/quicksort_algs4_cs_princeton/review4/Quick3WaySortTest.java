package com.yy.quicksort.quicksort_algs4_cs_princeton.review4;

import com.yy.quicksort.Sort;
import org.junit.Test;


public class Quick3WaySortTest {
    Sort sort = new Quick3WaySort();

    @Test
    public void sort() {
        sort.sort(new Integer[]{1, 1, 0, 0, 2, 3});
    }

    @Test
    public void sort1() {
        sort.sort(new Integer[]{1, 1, 4, 5, 6, 6, 0, 0, 2, 3});
    }

    @Test
    public void sort2() {
        sort.sort(new Integer[]{
                -74, 48, -20, 2, 10, -84, -5, -9, 11, -24, -91, 2, -71, 64, 63, 80, 28, -30, -58, -11, -44, -87, -22, 54, -74, -10, -55, -28, -46, 29, 10, 50, -72, 34, 26, 25, 8, 51, 13, 30, 35, -8, 50, 65, -6, 16, -2, 21, -78, 35, -13, 14, 23, -3, 26, -90, 86, 25, -56, 91, -13, 92, -25, 37, 57, -20, -69, 98, 95, 45, 47, 29, 86, -28, 73, -44, -46, 65, -84, -96, -24, -12, 72, -68, 93, 57, 92, 52, -45, -2, 85, -63, 56, 55, 12, -85, 77, -39

        });
    }

    @Test
    public void sort4() {
        long l = System.nanoTime();
        Comparable[] a = new Integer[]{2,2,1,2,1,1,1,0,0,2,1,0,2,1,2,2,1,1,1,1,1,0,2,0,2,0,2,2,1,0,2,1,0,2,1,2,0,0,0,0,2,1,1,2,0,1,2,2,0,0,2,2,0,1,0,1,0,0,1,1,1,0,0,2,2,2,1,0,0,2,1,0,1,0,2,2,1,2,1,1,2,1,1,0,0,2,1,0,0};

        sort.sort(a);
        System.out.println(System.nanoTime() - l);

    }
}