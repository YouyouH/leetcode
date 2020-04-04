package com.yy.leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidParenthesesTest {
    ValidParentheses validParentheses = new ValidParentheses();

    @Test
    public void isValid() {
        Assert.assertEquals(true, validParentheses.isValid(""));
        Assert.assertEquals(false, validParentheses.isValid(null));
        Assert.assertEquals(true, validParentheses.isValid("  "));
    }

    @Test
    public void isValid1() {
        Assert.assertEquals(false, validParentheses.isValid("([)]"));
        Assert.assertEquals(true, validParentheses.isValid("()[]{}"));
    }

    @Test
    public void isValid2() {
        boolean valid = validParentheses.isValid("((([{}])))");
        Assert.assertEquals(true, valid);
    }
}