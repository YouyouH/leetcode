package com.yy.leetcode.dynamicprogramming;

import org.junit.Test;

public class HouseRobberTest {

    @Test
    public void rob() {

        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(new int[]{2,7,9,3,1}));
        System.out.println(houseRobber.rob(new int[]{2,1}));
        System.out.println(houseRobber.rob(new int[]{2}));
        System.out.println(houseRobber.rob(new int[]{2,1,1,2,0}));
        System.out.println(houseRobber.rob(new int[]{2,1,1,2}));
        System.out.println(houseRobber.rob(new int[]{2,1,1,2,1}));
        System.out.println(houseRobber.rob(new int[]{2,1,1}));

    }
}