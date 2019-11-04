package com.yy.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class HouseRobberIITest {

    @Test
    public void rob() {
        HouseRobberII houseRobberII = new HouseRobberII();
        System.out.println(houseRobberII.rob(null));
        System.out.println(houseRobberII.rob(new int[]{2}));
        System.out.println(houseRobberII.rob(new int[]{2,3}));
        System.out.println(houseRobberII.rob(new int[]{2,3,2}));
        System.out.println(houseRobberII.rob(new int[]{1,2,3,1}));
        System.out.println(houseRobberII.rob(new int[]{1,2,3,1,1}));
        System.out.println(houseRobberII.rob(new int[]{1,2,3,1,4}));
    }
}