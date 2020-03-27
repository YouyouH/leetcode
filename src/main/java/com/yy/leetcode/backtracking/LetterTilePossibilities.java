package com.yy.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author youyouhuang
 * @create 2020-03-27
 * @desc https://leetcode-cn.com/problems/subsets-ii/
 * 给定一个可能包含重复元素的整数数组 tiles，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 **/

public class LetterTilePossibilities {

    public int numTilePossibilities(String tiles) {
        List<List<Character>> result = new ArrayList<>();
        //用来记录使用过的元素
        boolean[] used = new boolean[tiles.length()];
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        traverse(chars,0,new ArrayList<>(),result,used);
        return result.size();
    }

    private void traverse(char[] tiles, int depth, List<Character> cur, List<List<Character>> result, boolean[] used) {

        if(depth == tiles.length){
            return;
        }

        for (int i = 0; i < tiles.length; i++) {
            if(!used[i]) {
                /**
                 * https://leetcode.com/problems/letter-tile-possibilities/discuss/308333/Simple-Java-solution-of-backtracking-no-need-for-extra-space
                 * Why if(i - 1 >= 0 && chars[i] == chars[i - 1] && visited[i - 1]) continue; doesn't work:
                 *
                 * Take the input tile of "A1A2B" for example. Say we are building the current path as "A1". When we go to visit A2, according to if(i - 1 >= 0 && chars[i] == chars[i - 1] && visited[i - 1]) continue;, we should decide to abandon A2 cause A1 is marked as visited, right? But actually "A1A2" should be a valid answer.
                 * The purpose of if(i - 1 >= 0 && chars[i] == chars[i - 1] && !visited[i - 1]) is to avoid adding same char at the same position like "BA1" and "BA2".
                 *
                 * 以"A1A2B" 为例
                 * 如果出现 tiles[i] == tiles[i-1] 并且 used[i-1] == false,则遇到了BA2的情况，但是此前肯定已经计算了BA1，所以BA2应该丢弃。
                 */
                if(i>0 && tiles[i] == tiles[i-1] && !used[i-1]){
                    continue;
                }

                used[i] = true;
                cur.add(tiles[i]);
                result.add(new ArrayList<>(cur));
                traverse(tiles, depth+1, cur, result, used);
                cur.remove(cur.size() - 1);
                used[i] = false;
            }
        }
    }
}
