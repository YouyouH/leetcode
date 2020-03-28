package com.yy.leetcode.trie;

/**
 * @author youyouhuang
 * @create 2020-03-28
 * @desc
 **/

public class TrieNode {

    public char character;

    public boolean isWord = false;

    //26个英文字母
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {
    }

    public TrieNode(Character character) {
        this.character = character;
    }
}
