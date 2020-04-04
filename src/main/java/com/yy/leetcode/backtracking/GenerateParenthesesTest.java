package com.yy.leetcode.backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GenerateParenthesesTest {
    GenerateParentheses generateParentheses = new GenerateParentheses();

    @Test
    public void generateParenthesis0() {
        List<String> strings = generateParentheses.generateParenthesis(0);
        Assert.assertEquals(0, strings.size());

        List<String> strings2 = generateParentheses.generateParenthesis(-1);
        Assert.assertEquals(0, strings2.size());

        List<String> strings3 = generateParentheses.generateParenthesis(1);
        Assert.assertEquals(1, strings3.size());
    }

    @Test
    public void generateParenthesis() {
        List<String> strings = generateParentheses.generateParenthesis(3);
        Assert.assertArrayEquals(new String[]{
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"
        }, strings.toArray());
    }
}