package com.yy.leetcode.dfs;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SurroundedRegionsTest {

    @Test
    public void solve() {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] input = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        surroundedRegions.solve(
                input);

        Assert.assertArrayEquals(new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}}, input);
    }

    @Test
    public void solve1() {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] input = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        surroundedRegions.solve(
                input);

        Assert.assertArrayEquals(new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'}}, input);
    }

    @Test
    public void solve2() {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] input = {
                {'X', 'O', 'X', 'X'},
                };
        surroundedRegions.solve(
                input);

        Assert.assertArrayEquals(new char[][]{
                {'X', 'O', 'X', 'X'}
                }, input);
    }

    @Test
    public void solve3() {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] input = {
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'X', 'X'}
        };
        surroundedRegions.solve(
                input);

        Assert.assertArrayEquals(new char[][]{
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'X', 'X'}
        }, input);
    }
}