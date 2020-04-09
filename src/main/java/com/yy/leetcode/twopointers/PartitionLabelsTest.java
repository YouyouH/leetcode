package com.yy.leetcode.twopointers;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PartitionLabelsTest {

    PartitionLabels partitionLabels = new PartitionLabels();

    @Test
    public void partitionLabels() {
        Assert.assertArrayEquals(new Integer[]{1,1},partitionLabels.partitionLabels("ab").toArray());
        Assert.assertArrayEquals(new Integer[]{1},partitionLabels.partitionLabels("a").toArray());
        Assert.assertArrayEquals(new Integer[]{},partitionLabels.partitionLabels("").toArray());
        Assert.assertArrayEquals(new Integer[]{},partitionLabels.partitionLabels(null).toArray());
    }

    @Test
    public void partitionLabels1() {
        List<Integer> results = partitionLabels.partitionLabels("ababcbacadefegdehijhklij");
        Assert.assertArrayEquals(new Integer[]{9,7,8},results.toArray());
    }
}