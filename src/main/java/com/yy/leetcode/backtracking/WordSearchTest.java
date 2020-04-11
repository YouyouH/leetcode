package com.yy.leetcode.backtracking;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchTest {

    WordSearch wordSearch = new WordSearch();

    @Test
    public void exist0() {
        Assert.assertTrue(wordSearch.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
    }

    @Test
    public void exist1() {
        Assert.assertTrue(wordSearch.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE"));
    }

    @Test
    public void exist2() {
        Assert.assertFalse(wordSearch.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB"));
    }

    @Test
    public void exist3() {
        Assert.assertFalse(wordSearch.exist(null
                , "ABCCED"));
        Assert.assertFalse(wordSearch.exist(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                }
                , null));
    }

    @Test
    public void exist4() {
        Assert.assertTrue(wordSearch.exist(new char[][]{
                        {'a', 'b'},
                        {'c', 'd'}
                }
                , "cdba"));
    }

    @Test
    public void exist5() {
        Assert.assertTrue(wordSearch.exist(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'E', 'S'},
                        {'A', 'D', 'E', 'E'}
                }
                , "ABCESEEEFS"));
    }
}