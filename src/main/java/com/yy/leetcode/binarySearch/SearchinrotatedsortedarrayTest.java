package com.yy.leetcode.binarySearch;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchinrotatedsortedarrayTest {
    Searchinrotatedsortedarray searchinrotatedsortedarray = new Searchinrotatedsortedarray();
    @Test
    public void search() {
        Assert.assertEquals(4, searchinrotatedsortedarray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        Assert.assertEquals(6, searchinrotatedsortedarray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
        Assert.assertEquals(4, searchinrotatedsortedarray.search(new int[]{4,5,6,7,8,1,2,3}, 8));
        Assert.assertEquals(1, searchinrotatedsortedarray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        Assert.assertEquals(0, searchinrotatedsortedarray.search(new int[]{1}, 1));
        Assert.assertEquals(-1, searchinrotatedsortedarray.search(new int[]{1}, 0));
        Assert.assertEquals(1, searchinrotatedsortedarray.search(new int[]{3,1}, 1));
    }

}