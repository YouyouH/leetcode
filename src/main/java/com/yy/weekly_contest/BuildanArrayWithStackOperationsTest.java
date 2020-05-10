package com.yy.weekly_contest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildanArrayWithStackOperationsTest {
    BuildanArrayWithStackOperations buildanArrayWithStackOperations = new BuildanArrayWithStackOperations();
    @Test
    public void buildArray() {
        buildanArrayWithStackOperations.buildArray(new int[]{1,3,4,6},8);
    }

    @Test
    public void buildArray1() {
        buildanArrayWithStackOperations.buildArray(new int[]{2,3,4},4);
    }

    @Test
    public void buildArray2() {
        Assert.assertEquals(3,buildanArrayWithStackOperations.buildArray(new int[]{2},4).size());
        Assert.assertEquals(1,buildanArrayWithStackOperations.buildArray(new int[]{1},4).size());
    }
}