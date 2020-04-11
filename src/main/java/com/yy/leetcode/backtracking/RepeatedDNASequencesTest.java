package com.yy.leetcode.backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RepeatedDNASequencesTest {
    RepeatedDNASequences repeatedDNASequences = new RepeatedDNASequences();
    @Test
    public void findRepeatedDnaSequences() {
        List<String> result = repeatedDNASequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        Assert.assertArrayEquals(new String[]{"AAAAACCCCC", "CCCCCAAAAA"},result.toArray());
    }
}