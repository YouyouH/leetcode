  //实现一个 MapSum 类，支持两个方法，insert 和 sum： 
//
// 
// MapSum() 初始化 MapSum 对象 
// void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 
//key 已经存在，那么原来的键值对将被替代成新的键值对。 
// int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//inputs = ["MapSum", "insert", "sum", "insert", "sum"]
//inputs = [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//输出：
//[null, null, 3, null, 5]
//
//解释：
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);  
//mapSum.sum("ap");           // return 3 (apple = 3)
//mapSum.insert("app", 2);    
//mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length, prefix.length <= 50 
// key 和 prefix 仅由小写英文字母组成 
// 1 <= val <= 1000 
// 最多调用 50 次 insert 和 sum 
// 
//
// 
//
// 注意：本题与主站 677 题相同： https://leetcode-cn.com/problems/map-sum-pairs/ 
// Related Topics 设计 字典树 哈希表 字符串 👍 10 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-03-09 22:45:19 
//单词之和

  import java.util.HashMap;
  import java.util.Map;

  public class Z1R5dt{
    public static void main(String[] args) {
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MapSum {

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
            } else {
                return key.charAt(i) - 'A' + 'z' - 'a' + 1;
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

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}