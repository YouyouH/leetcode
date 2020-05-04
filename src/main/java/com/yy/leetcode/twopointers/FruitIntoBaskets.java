package com.yy.leetcode.twopointers;
/**
 * @author youyouhuang
 * @create 2020-05-04
 **/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 在一排树中，第 i 棵树产生 tree[i] 型的水果。 你可以从你选择的任何树开始，然后重复执行以下步骤：      把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。     移动到当前树右侧的下一棵树。如果右边没有树，就停下来。  请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。  你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。 用这个程序你能收集的水果总量是多少？  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/fruit-into-baskets 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * </p>
 **/
public class FruitIntoBaskets {

    public int totalFruit(int[] tree) {
        int max = 0;
        int lo = 0;
        int hi = 0;
        Map<Integer,Integer> selectedTypes = new HashMap<>();
        selectedTypes.put(tree[0],1);
        while (hi < tree.length) {
            while (selectedTypes.size() < 3 && ++hi < tree.length) {
                selectedTypes.merge(tree[hi], 1, Integer::sum);
            }
            max = Math.max(max, hi - lo);

            while (selectedTypes.size() > 2 && lo < tree.length) {
                Integer integer = selectedTypes.get(tree[lo]);
                if(integer == 1){
                    selectedTypes.remove(tree[lo]);
                }else{
                    selectedTypes.put(tree[lo],integer-1);
                }
                lo++;
            }
        }
        return max;
    }
}
