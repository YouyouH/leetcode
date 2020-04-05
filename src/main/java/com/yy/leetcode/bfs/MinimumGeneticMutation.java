package com.yy.leetcode.bfs;
/**
 * @author youyouhuang
 * @create 2020-04-05
 **/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * <p>
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * <p>
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * <p>
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * <p>
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，
 * 请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 * <p>
 * 注意:
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。     假定起始基因序列与目标基因序列是不一样的。
 * <p>
 * 示例 1:  start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * 返回值: 1
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MinimumGeneticMutation {


    /**
     * 由起点开始，以宽度优先的方式往queue里添加在bank里的所有变化字符串。结构上相当于多叉树的宽度优先遍历
     */
    public int minMutation(String start, String end, String[] bank) {
        if(start.length() != 8 || end.length() != 8 || bank.length == 0){
            return -1;
        }
        Set<String> bankSet = Arrays.stream(bank).collect(Collectors.toSet());
        if (!bankSet.contains(end)) {
            return -1;
        }
        int level = 0;
        bankSet.remove(start);
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while(size-- > 0) {
                String seq = queue.poll();
                for (int i = 0; i < seq.length(); i++) {
                    if(replace(bankSet, queue, seq, i, 'A',end)||
                    replace(bankSet, queue, seq, i, 'C', end) ||
                    replace(bankSet, queue, seq, i, 'G', end) ||
                    replace(bankSet, queue, seq, i, 'T', end)){
                        return level;
                    }
                }
            }
        }
        return -1;
    }

    private boolean replace(Set<String> bankSet, Queue<String> queue, String seq, int i, char ch, String end) {
        char[] charArray = seq.toCharArray();
        charArray[i] = ch;
        String s = new String(charArray);
        if(s.equals(end)){
            return true;
        }
        if(bankSet.remove(s)){
            queue.offer(s);
        }
        return false;
    }
}
