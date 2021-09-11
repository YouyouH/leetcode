package com.yy.leetcode.unclear;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTest {
    Merge merge = new Merge();

    @Test
    public void merge() {
        merge.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        merge.merge(new int[][]{{1,4},{5,6}});
    }
}