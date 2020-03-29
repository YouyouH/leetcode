package com.yy.quicksort;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Repeatable;

import static org.junit.Assert.*;

public class SortColorsTest {

    SortColors sortColors = new SortColors();

    @Test
    public void sortColors1() {
        long l = System.nanoTime();
        QuickSortImpl quickSort = new QuickSortImpl();
        Integer[] colors = {0, 1, 2, 1, 1, 2, 0, 0, 0};
        quickSort.sort(colors);
        System.out.println("QuickSort: " + (System.nanoTime() - l));
        Assert.assertArrayEquals(new Integer[]{0, 0, 0, 0, 1, 1, 1, 2, 2}, colors);

        long l1 = System.nanoTime();
        int[] colors1 = {0, 1, 2, 1, 1, 2, 0, 0, 0};
        sortColors.sortColors(colors1);
        System.out.println("SortColor: " + (System.nanoTime() - l1));
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 1, 1, 1, 2, 2}, colors1);
    }

    @Test()
    public void sortColors() {
        long l = System.nanoTime();
        int[] colors = {2, 2, 1, 2, 1, 1, 1, 0, 0, 2, 1, 0, 2, 1, 2, 2, 1, 1, 1, 1, 1, 0, 2, 0, 2, 0, 2, 2, 1, 0, 2, 1, 0, 2, 1, 2, 0, 0, 0, 0, 2, 1, 1, 2, 0, 1, 2, 2, 0, 0, 2, 2, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 2, 2, 2, 1, 0, 0, 2, 1, 0, 1, 0, 2, 2, 1, 2, 1, 1, 2, 1, 1, 0, 0, 2, 1, 0, 0
        };
        sortColors.sortColors(colors);
        System.out.println(System.nanoTime() - l);
    }


}