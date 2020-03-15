package com.yy.leetcode.greedy;

import org.junit.Test;

import java.util.List;

public class groupthepeopleTest {

    groupthepeople_incorrect groupthepeople = new groupthepeople_incorrect();

    @Test
    public void groupThePeople() {
        List<List<Integer>> lists = groupthepeople.groupThePeople(new int[]{2, 2, 2, 1, 1});
    }

    @Test
    public void groupThePeople1() {
        List<List<Integer>> lists = groupthepeople.groupThePeople(null);
    }
}