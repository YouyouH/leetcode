package com.yy.quicksort;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

//    QuickSort quickSort = new QuickSortImpl();
    QuickSort quickSort = new QuickSortReview();

    @Test
    public void sort() {

        Comparable[] a = new Integer[]{4,3,2,1};

        quickSort.sort(a);

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