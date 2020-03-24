package com.yy.leetcode.backtracking;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author youyouhuang
 * @create 2020-03-24
 * @desc https://leetcode-cn.com/problems/letter-case-permutation/
 * <p>
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 **/

/**
 * 方法一：迭代
 * 方法二：递归。把左右子树看成小写和大写 [dummy,a,A,ab,aB,Ab,AB...]一棵二叉树
 *
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        if(S == null || S.isEmpty()){
            return new ArrayList<>();
        }
        List<StringBuilder> array = new ArrayList<>();
        array.add(new StringBuilder());

        for (int i = 0; i < S.length(); i++) {
            List<StringBuilder> tmp = new ArrayList<>();
            for (StringBuilder builder : array) {
                if(Character.isLetter(S.charAt(i))) {
                    StringBuilder builder1 = new StringBuilder(builder.toString()).append(S.toUpperCase().charAt(i));
                    StringBuilder builder2 = new StringBuilder(builder.toString()).append(S.toLowerCase().charAt(i));
                    tmp.add(builder1);
                    tmp.add(builder2);
                }else{
                    StringBuilder builder1 = new StringBuilder(builder.toString()).append(S.charAt(i));
                    tmp.add(builder1);
                }
            }
            array.clear();
            array.addAll(tmp);
        }
        return array.stream().map(stringBuilder -> stringBuilder.toString()).collect(Collectors.toList());
    }
}
