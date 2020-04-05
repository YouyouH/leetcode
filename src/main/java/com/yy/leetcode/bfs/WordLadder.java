package com.yy.leetcode.bfs;
/**
 * @author youyouhuang
 * @create 2020-04-05
 **/

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * <p>每次转换只能改变一个字母。
 * <p>转换过程中的中间单词必须是字典中的单词。
 * <p>
 * <p>说明:
 * <p>如果不存在这样的转换序列，返回 0。
 * <p>所有单词具有相同的长度。
 * <p>所有单词只由小写字母组成。
 * <p>字典中不存在重复的单词。
 * <p>你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * <p>
 * <p>示例 1:
 * <p>
 * <p>输入:
 * <p>beginWord = "hit",
 * <p>endWord = "cog",
 * <p>wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * <p>输出: 5
 * <p>
 * <p>来源：力扣（LeetCode）
 * <p>链接：https://leetcode-cn.com/problems/word-ladder
 * <p>著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() < 1 || endWord.length() < 1 || wordList.size() == 0) {
            return 0;
        }
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        int level = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                String word = queue.poll();
                for (int i = 0; i < word.length(); i++) {
                    for (int j = 'a'; j < 'z' + 1; j++) {
                        char[] chars = word.toCharArray();
                        chars[i] = (char) j;
                        String newWord = new String(chars);
                        if (newWord.equals(endWord)) {
                            return level;
                        }
                        if (wordSet.remove(newWord)) {
                            queue.offer(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
