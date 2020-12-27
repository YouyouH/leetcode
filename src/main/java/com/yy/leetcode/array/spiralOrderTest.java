package com.yy.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class spiralOrderTest {
    spiralOrder spiralOrder = new spiralOrder();

    @Test
    public void spiralOrder() {

        spiralOrder.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        //方法二
        spiralOrder.spiralOrder2(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}