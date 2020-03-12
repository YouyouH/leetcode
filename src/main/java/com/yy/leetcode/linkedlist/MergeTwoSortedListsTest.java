package com.yy.leetcode.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTwoSortedListsTest {

    MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
    @Test
    public void mergeTwoLists() {
        Assert.assertEquals(mergeTwoSortedLists.mergeTwoLists(null,null),null);
    }
}