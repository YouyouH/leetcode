  //给定一个整数数组 asteroids，表示在同一行的小行星。 
//
// 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。 
//
// 找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰
//撞。 
//
// 
//
// 示例 1： 
//
// 
//输入：asteroids = [5,10,-5]
//输出：[5,10]
//解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。 
//
// 示例 2： 
//
// 
//输入：asteroids = [8,-8]
//输出：[]
//解释：8 和 -8 碰撞后，两者都发生爆炸。 
//
// 示例 3： 
//
// 
//输入：asteroids = [10,2,-5]
//输出：[10]
//解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。 
//
// 示例 4： 
//
// 
//输入：asteroids = [-2,-1,1,2]
//输出：[-2,-1,1,2]
//解释：-2 和 -1 向左移动，而 1 和 2 向右移动。 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。 
//
// 
//
// 提示： 
//
// 
// 2 <= asteroids.length <= 10⁴ 
// -1000 <= asteroids[i] <= 1000 
// asteroids[i] != 0 
// 
//
// 
//
// 注意：本题与主站 735 题相同： https://leetcode-cn.com/problems/asteroid-collision/ 
// Related Topics 栈 数组 👍 18 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-03-10 22:38:10 
//小行星碰撞

  import java.util.*;
  import java.util.stream.Collectors;

  public class XagZNi{
    public static void main(String[] args) {
         Solution solution = new XagZNi().new Solution();
        solution.asteroidCollision(new int[]{5,10,-5});
        solution.asteroidCollision(new int[]{-2,-1,1,2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty()) {
                stack.push(asteroid);
            }else {
                //当要发生碰撞并且外面的始终大于里面的
                while (!stack.isEmpty() && stack.peek()>0 && asteroid < 0 && Math.abs(asteroid) > Math.abs(stack.peek())) {
                    //一直循环，直到都是同方向的
                    //当前的大，把里面的弹出，当前push
                    stack.pop();
                }

                //碰撞并且外面的小于里面的，直接跳过
                if (!stack.isEmpty() && stack.peek()>0 && asteroid < 0 && Math.abs(asteroid) < Math.abs(stack.peek())) {
                    continue;
                }

                //碰撞并且外面的等于里面的，弹出然后跳过
                if (!stack.isEmpty() && stack.peek()>0 && asteroid < 0 && Math.abs(asteroid) == Math.abs(stack.peek())) {
                    stack.pop();
                    continue;
                }
                //相同方向，不碰撞，继续push
                stack.push(asteroid);

            }
        }
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pollLast());
        }
        return res.stream().mapToInt(a -> a).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}