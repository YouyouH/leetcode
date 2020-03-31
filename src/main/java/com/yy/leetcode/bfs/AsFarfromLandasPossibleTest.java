package com.yy.leetcode.bfs;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AsFarfromLandasPossibleTest {

    AsFarfromLandasPossible asFarfromLandasPossible = new AsFarfromLandasPossible();

    @Test
    public void maxDistance0() {
        int[][] input = new int[][]{
        };
        int result = asFarfromLandasPossible.maxDistance(input);
        Assert.assertEquals(-1,result);
    }

    @Test
    public void maxDistance1() {
        int[][] input = new int[][]{{1,1,1}
        };
        int result = asFarfromLandasPossible.maxDistance(input);
        Assert.assertEquals(-1,result);

        int[][] input1 = new int[][]{{1,0,1}
        };
        int result1 = asFarfromLandasPossible.maxDistance(input1);
        Assert.assertEquals(1,result1);
    }
    @Test
    public void maxDistance1_1() {
        int[][] input = new int[][]{{0,0,0}
        };
        int result = asFarfromLandasPossible.maxDistance(input);
        Assert.assertEquals(-1,result);
    }

    @Test
    public void maxDistance2() {
        int[][] input = new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        int result = asFarfromLandasPossible.maxDistance(input);
        Assert.assertEquals(2,result);
    }

    @Test
    public void maxDistance3() {
        int[][] input = new int[][]{
                {1, 0, 1,1},
                {0, 0, 0,1},
                {1, 0, 1,1},
                {0, 0, 0,1},
                {0, 0, 0,0},
        };
        int result = asFarfromLandasPossible.maxDistance(input);
        Assert.assertEquals(3,result);
    }

    @Test
    public void maxDistance4() {
        int[][] input = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int result = asFarfromLandasPossible.maxDistance(input);
        Assert.assertEquals(2,result);
    }

    @Test
    public void maxDistance5() {
        int[][] input = new int[][]
        {
        {1,0,0,0,0,1,0,0,0,1},
        {1,1,0,1,1,1,0,1,1,0},
        {0,1,1,0,1,0,0,1,0,0},
        {1,0,1,0,1,0,0,0,0,0},
        {0,1,0,0,0,1,1,0,1,1},
        {0,0,1,0,0,1,0,1,0,1},
        {0,0,0,1,1,1,1,0,0,1},
        {0,1,0,0,1,0,0,1,0,0},
        {0,0,0,0,0,1,1,1,0,0},
        {1,1,0,1,1,1,1,1,0,0}};

        int result = asFarfromLandasPossible.maxDistance(input);
        Assert.assertEquals(2,result);
    }
}