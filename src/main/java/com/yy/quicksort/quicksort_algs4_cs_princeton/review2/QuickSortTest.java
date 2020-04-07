package com.yy.quicksort.quicksort_algs4_cs_princeton.review2;

import com.yy.quicksort.QuickSortImpl;
import com.yy.quicksort.Sort;
import com.yy.quicksort.quicksort_algs4_cs_princeton.Quick3way;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {
    Sort sort = new QuickSort();

    @Test()
    public void sortColors() {
        long l = System.nanoTime();
        Integer[] colors = {2, 2, 1, 2, 1, 1, 1, 0, 0, 2, 1, 0, 2, 1, 2, 2, 1, 1, 1, 1, 1, 0, 2, 0, 2, 0, 2, 2, 1, 0, 2, 1, 0, 2, 1, 2, 0, 0, 0, 0, 2, 1, 1, 2, 0, 1, 2, 2, 0, 0, 2, 2, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 2, 2, 2, 1, 0, 0, 2, 1, 0, 1, 0, 2, 2, 1, 2, 1, 1, 2, 1, 1, 0, 0, 2, 1, 0, 0
        };
        sort.sort(colors);
        System.out.println(System.nanoTime() - l);
    }

    @Test()
    public void sortColors1() {

        Integer[] colors = {1,3,2,8,7,11,2,2};
        long l = System.nanoTime();
        sort.sort(colors);
        System.out.println("---------------start---------------");
        System.out.println("review:" + String.valueOf(System.nanoTime() - l));
        System.out.println("------------------------------");
        Assert.assertArrayEquals(new Integer[]{1,2,2,2,3,7,8,11},colors);
        long l1 = System.nanoTime();
        Quick3way.sort(colors);
        System.out.println("princeton:" + String.valueOf(System.nanoTime() - l1));
        System.out.println("---------------end---------------");

    }
}