package com.yy.leetcode.greedy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author youyouhuang
 * @create 2020-03-14
 * @desc 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组 groupSizes，其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
 * <p>
 * 你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-the-people-given-the-group-size-they-belong-to
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/


public class groupthepeople_incorrect {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        if(groupSizes == null || groupSizes.length == 0){
            return result;
        }
        int length = groupSizes.length;

        Set<Integer> size = new TreeSet();
        for (int groupSize : groupSizes) {
            size.add(groupSize);
        }
        List<Integer> minimalSize = new ArrayList<>(size);

        int n = 0;
        for (int t = minimalSize.size() - 1; t > -1; t--) {
            Integer number = minimalSize.get(t);
            for (int k = 1; listSzie(result) + number <= length; k++) {
                List<Integer> group = new ArrayList<>();
                for (int i = 0; i < number; i++) {
                    group.add(n);
                    n++;
                }
                result.add(group);
            }
        }
        return result;
    }

    int listSzie(List<List<Integer>> list){
        return list.stream().flatMap(r->r.stream()).collect(Collectors.toList()).size();
    }
}
