package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class MapSumTest {

    @Test
    public void insert() {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        mapSum.sum("ap");
        mapSum.insert("app", 2);
        mapSum.sum("ap");
        mapSum.sum("aa");
    }
}