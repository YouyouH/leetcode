package com.yy.quicksort.quicksort_algs4_cs_princeton.review1;

import com.yy.quicksort.QuickSortImpl;
import com.yy.quicksort.Sort;
import org.junit.Assert;
import org.junit.Test;

public class Quick3wayReviewTest {

    Sort quick3wayReview = new Quick3wayReview();

    @Test
    public void sortColors1() {
        long l = System.nanoTime();
        QuickSortImpl quickSort = new QuickSortImpl();
        Integer[] colors = {0, 1, 2, 1, 1, 2, 0, 0, 0};
        quickSort.sort(colors);
        System.out.println("QuickSort: " + (System.nanoTime() - l));
        Assert.assertArrayEquals(new Integer[]{0, 0, 0, 0, 1, 1, 1, 2, 2}, colors);

        long l1 = System.nanoTime();
        Integer[] colors1 = {0, 1, 2, 1, 1, 2, 0, 0, 0};
        quick3wayReview.sort(colors1);
        System.out.println("quick3way: " + (System.nanoTime() - l1));
        Assert.assertArrayEquals(new Integer[]{0, 0, 0, 0, 1, 1, 1, 2, 2}, colors1);
    }

    @Test()
    public void sortColors() {
        long l = System.nanoTime();
        Integer[] colors = {2, 2, 1, 2, 1, 1, 1, 0, 0, 2, 1, 0, 2, 1, 2, 2, 1, 1, 1, 1, 1, 0, 2, 0, 2, 0, 2, 2, 1, 0, 2, 1, 0, 2, 1, 2, 0, 0, 0, 0, 2, 1, 1, 2, 0, 1, 2, 2, 0, 0, 2, 2, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 2, 2, 2, 1, 0, 0, 2, 1, 0, 1, 0, 2, 2, 1, 2, 1, 1, 2, 1, 1, 0, 0, 2, 1, 0, 0
        };
        quick3wayReview.sort(colors);
        System.out.println(System.nanoTime() - l);
    }
}