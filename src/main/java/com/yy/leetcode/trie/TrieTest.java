package com.yy.leetcode.trie;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

public class TrieTest {

    @Test
    public void insert() {
        Trie trie = new Trie();
        trie.insert("youyouhuang");
        Assert.assertTrue(trie.search("youyouhuang"));
        Assert.assertFalse(trie.search("youyou"));
        Assert.assertTrue(trie.startsWith("youyou"));

        trie.insert("youyou");
        Assert.assertTrue(trie.search("youyou"));
    }

    @Test
    public void search() {
    }

    @Test
    public void startsWith() {
    }
}