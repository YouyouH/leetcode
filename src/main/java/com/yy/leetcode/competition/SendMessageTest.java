package com.yy.leetcode.competition;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SendMessageTest {
    SendMessage sendMessage = new SendMessage();
    @Test
    public void numWays() {
        Assert.assertEquals(4,sendMessage.numWays(5,new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4},{4,2},{4,0}},3));
        Assert.assertEquals(3,sendMessage.numWays(5,new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4},{4,2}},4));
        Assert.assertEquals(0,sendMessage.numWays(6,new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4},{4,2}},4));
        Assert.assertEquals(4,sendMessage.numWays(5,new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4},{4,2},{4,1}},3));
        Assert.assertEquals(3,sendMessage.numWays(5,new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}},3));
        Assert.assertEquals(1,sendMessage.numWays(5,new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}},1));
        Assert.assertEquals(0,sendMessage.numWays(5,new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}},2));
        Assert.assertEquals(0,sendMessage.numWays(3,new int[][]{{0,2},{2,1}},2));
        Assert.assertEquals(0,sendMessage.numWays(5,new int[][]{},2));
        Assert.assertEquals(0,sendMessage.numWays(5,new int[][]{{0,1}},1));
        Assert.assertEquals(1,sendMessage.numWays(2,new int[][]{{0,1}},1));
    }

    /**
     * 8
     * [[2,3],[4,1],[4,5],[2,0],[7,1],[1,7],[5,6],[6,1],[6,7],[3,6],[2,7],[7,5],[1,3],[2,1],[4,6],[7,6],[0,2],[3,1],[4,0],[5,1],[3,0],[5,4]]
     * 1
     */
    @Test
    public void numWays1() {
        int[][] input = new int[][]{{2,3},{4,1},{4,5},{2,0},{7,1},{1,7},{5,6},{6,1},{6,7},{3,6},{2,7},{7,5},{1,3},{2,1},{4,6},{7,6},{0,2},{3,1},{4,0},{5,1},{3,0},{5,4}};
        sendMessage.numWays(8,input,1);
    }
}