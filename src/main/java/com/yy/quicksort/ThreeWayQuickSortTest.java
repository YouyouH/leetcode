package com.yy.quicksort;

import org.junit.Assert;
import org.junit.Test;

public class ThreeWayQuickSortTest {

    ThreeWayQuickSort threeWayQuickSort = new ThreeWayQuickSort();


    @Test
    public void sortColors() {
        long l = System.nanoTime();
        int[] colors = {2, 2, 1, 2, 1, 1, 1, 0, 0, 2, 1, 0, 2, 1, 2, 2, 1, 1, 1, 1, 1, 0, 2, 0, 2, 0, 2, 2, 1, 0, 2, 1, 0, 2, 1, 2, 0, 0, 0, 0, 2, 1, 1, 2, 0, 1, 2, 2, 0, 0, 2, 2, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 2, 2, 2, 1, 0, 0, 2, 1, 0, 1, 0, 2, 2, 1, 2, 1, 1, 2, 1, 1, 0, 0, 2, 1, 0, 0
        };
        int length = colors.length;
        threeWayQuickSort.sort(colors);
        Assert.assertEquals(length,colors.length);
        System.out.println(System.nanoTime() - l);
    }
}