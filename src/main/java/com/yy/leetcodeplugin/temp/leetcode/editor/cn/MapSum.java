package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

    MNode dummyNode;

    Map<String, Integer> map = new HashMap<>();
    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        //前缀树，但是注意区分大小写
        this.dummyNode = new MNode();
    }

    public void insert(String key, int val) {
        int add = val;
        if (map.containsKey(key)) {
            add = val - map.get(key);
        }
        map.put(key, val);

        MNode p = dummyNode;
        for (int i = 0; i < key.length(); i++) {
            int index = getIndex(key, i);
            if (p.children[index] == null) {
                p.children[index] = new MNode();
            }
            //倒了单词结尾
//            if (i == key.length() - 1) {
//                if (p.children[index].isWord) {
//                    //替换上一个单词的值
//                    p.children[index].val = val;
//                    p = p.children[index];
//                    continue;
//                }
//                //标记单词结尾
//                p.children[index].isWord = true;
//            }
            p.children[index].val += add;
            p = p.children[index];
        }
    }

    private int getIndex(String key, int i) {
        if (key.charAt(i) >= 'a' && key.charAt(i) <= 'z') {
            return key.charAt(i) - 'a';
        }else {
            return key.charAt(i) - 'A'+'z'-'a'+1;
        }
    }

    public int sum(String prefix) {
        int res = 0;
        MNode p = dummyNode;
        for (int i = 0; i < prefix.length(); i++) {
            int index = getIndex(prefix, i);

            if (null == p.children[index]) {
                return 0;
            }
//            res += p.children[index].val;
            p = p.children[index];
        }
        return p.val;
    }
}
 class MNode {
    int val;
    boolean isWord = false;
    Character ch;
    //区分大小写
    MNode[] children = new MNode[52];
}
