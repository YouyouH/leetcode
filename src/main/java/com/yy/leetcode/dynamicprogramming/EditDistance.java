package com.yy.leetcode.dynamicprogramming;
/**
 * @author youyouhuang
 * @create 2020-04-07
 **/

/**
 * <p>给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p> 你可以对一个单词进行如下三种操作：
 * <p> 插入一个字符
 * <p> 删除一个字符
 * <p> 替换一个字符
 * <p>
 * <p> 示例 1：
 * <p>
 * <p> 输入：word1 = "horse", word2 = "ros"
 * <p> 输出：3
 * <p> 解释：
 * <p> horse -> rorse (将 'h' 替换为 'r')
 * <p> rorse -> rose (删除 'r')
 * <p> rose -> ros (删除 'e')
 * <p>
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class EditDistance {

    //回溯法超出时间限制，需要加dp table
    public int minDistance(String word1, String word2) {
        if(null == word1 || null == word2){
            return 0;
        }
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        return traverseString(0, 0, word1, word2,dp);
    }

    private int traverseString(int i, int j, String word1, String word2, int[][] dp) {
        if (i >= word1.length()) {
            return word2.length() - j ;
        }
        if (j >= word2.length()) {
            return word1.length() - i ;
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return traverseString(i + 1, j + 1, word1, word2, dp);
        } else {
            int path1 = 0;
            if(dp[i][j+1] == 0){
                dp[i][j+1] = traverseString(i, j + 1, word1, word2, dp) + 1;
            }
            path1 = dp[i][j+1];


            int path2 = 0;
            if(dp[i+1][j] == 0){
                dp[i+1][j] = traverseString(i+1, j, word1, word2, dp) + 1;
            }
            path2 = dp[i+1][j];


            int path3 = 0;
            if(dp[i+1][j+1] == 0){
                dp[i+1][j+1] = traverseString(i+1, j+1, word1, word2, dp) + 1;
            }
            path3 = dp[i+1][j+1];


            return Math.min(Math.min(path1,path2),path3);
        }
    }
}
