package com.yy.leetcode.trie;

/**
 * @author youyouhuang
 * @create 2020-03-28
 * @desc https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 * 说明:
 *
 *     你可以假设所有的输入都是由小写字母 a-z 构成的。
 *     保证所有输入均为非空字符串。
 *
 **/

class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(null == word){
            return;
        }
        TrieNode pNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(pNode.children[ch-'a'] ==null){
                pNode.children[ch-'a'] = new TrieNode(ch);
            }
            //移动指针
            pNode = pNode.children[ch-'a'];
        }
        pNode.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(null == word){
            return false;
        }
        TrieNode pNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (pNode.children[ch - 'a'] == null) {
                return false;
            }
            pNode = pNode.children[ch - 'a'];
        }
        return pNode.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(null == prefix){
            return false;
        }
        TrieNode pNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (pNode.children[ch - 'a'] == null) {
                return false;
            }
            pNode = pNode.children[ch - 'a'];
        }
        return true;
    }
}



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
