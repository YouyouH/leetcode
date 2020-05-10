package com.yy.weekly_contest;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MinimumTimetoCollectAllApplesinaTreeTest {
    MinimumTimetoCollectAllApplesinaTree timetoCollectAllApplesinaTree= new MinimumTimetoCollectAllApplesinaTree();

    @Test
    public void minTime() {
        timetoCollectAllApplesinaTree.minTime(7,
                new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}},
                Arrays.asList(false,false,true,false,true,true,false));
    }
}