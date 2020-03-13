package com.yy.mergesort;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    MergeSort mergeSort = new MergeSort();

    @Test
    public void sort() {
        Integer[] integers = {5, 4, 3, 2, 1};
        mergeSort.sort(integers);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, integers);
    }

    @Test
    public void sort1() {
        Integer[] integers = {5, 5, 0, 4, 3, 2, 1};
        mergeSort.sort(integers);
        Assert.assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 5}, integers);
    }

    @Test
    public void sort2() {
        Integer[] integers = {0,0,0};
        mergeSort.sort(integers);
        Assert.assertArrayEquals(new Integer[]{0,0,0}, integers);
    }
}