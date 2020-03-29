package com.yy.quicksort;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

//    QuickSort quickSort = new QuickSortImpl();
    Sort quickSort = new QuickSortReview2();

    @Test
    public void sort() {
        long l = System.nanoTime();
        Comparable[] a = new Integer[]{2,2,1,2,1,1,1,0,0,2,1,0,2,1,2,2,1,1,1,1,1,0,2,0,2,0,2,2,1,0,2,1,0,2,1,2,0,0,0,0,2,1,1,2,0,1,2,2,0,0,2,2,0,1,0,1,0,0,1,1,1,0,0,2,2,2,1,0,0,2,1,0,1,0,2,2,1,2,1,1,2,1,1,0,0,2,1,0,0};

        quickSort.sort(a);
        System.out.println(System.nanoTime() - l);
        Assert.assertArrayEquals(new Integer[]{1,2,3,4}, a);

    }

    @Test
    public void sort1() {

        Comparable[] a = new Integer[]{ 0,0,1,1};

        quickSort.sort(a);

        Assert.assertArrayEquals(new Integer[]{0,0,1,1}, a);

    }

    @Test
    public void sort3() {

        Comparable[] a = new Integer[]{ 0,0,1,1,2,4,0};

        quickSort.sort(a);

        Assert.assertArrayEquals(new Integer[]{0,0,0,1,1,2,4}, a);

    }

    @Test
    public void sort2() {

        Comparable[] a = new Integer[]{1,2,3,4};

        quickSort.sort(a);

        Assert.assertArrayEquals(new Integer[]{1,2,3,4}, a);

    }
}