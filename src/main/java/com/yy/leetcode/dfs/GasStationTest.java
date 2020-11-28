package com.yy.leetcode.dfs;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GasStationTest {
    GasStation gasStation = new GasStation();

    @Test
    public void canCompleteCircuit() {
        Assert.assertEquals(3, gasStation.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        Assert.assertEquals(-1, gasStation.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

    @Test
    public void canCompleteCircui2() {
        Assert.assertEquals(3, gasStation.canCompleteCircuit2(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        Assert.assertEquals(-1, gasStation.canCompleteCircuit2(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
    @Test
    public void canCompleteCircui3() {
        Assert.assertEquals(4, gasStation.canCompleteCircuit2(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1}));
        Assert.assertEquals(-1, gasStation.canCompleteCircuit2(new int[]{6,0,1,3,2}, new int[]{4,5,2,5,5}));
    }
}