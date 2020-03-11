package com.yy.leetcode.twopointers;

/**
 * @author youyouhuang
 * @create 2020-03-10
 * @desc
 **/

/**
 * 思路：对于每一个柱子，能够盛的水等于左右两边最高的柱子的较小值减去当前柱子的高度。
 * 暴力法就是对诶一根柱子都计算一遍左右两边柱子的高度。
 *
 * 改进：1.用备忘录法记录左右两边的最高值
 *      2.双指针法记录两边最高值。
 *          从动态编程方法的示意图中我们注意到，只要 right_max[i]>left_max[i]\text{right\_max}[i]>\text{left\_max}[i]right_max[i]>left_max[i] （元素 0 到元素 6），积水高度将由 left_max 决定，类似地 left_max[i]>right_max[i]\text{left\_max}[i]>\text{right\_max}[i]left_max[i]>right_max[i]（元素 8 到元素 11）。
 *          所以我们可以认为如果一端有更高的条形块（例如右端），积水的高度依赖于当前方向的高度（从左到右）。当我们发现另一侧（右侧）的条形块高度不是最高的，我们则开始从相反的方向遍历（从右到左）。
 *          我们必须在遍历时维护 left_max\text{left\_max}left_max 和 right_max\text{right\_max}right_max ，但是我们现在可以使用两个指针交替进行，实现 1 次遍历即可完成。
 *
 *          作者：LeetCode
 *          链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
 *          来源：力扣（LeetCode）
 *          著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        //initialize two pointers
        int left = 0;
        int right = height.length-1;

        int leftMax = height[left];
        int rightMax = height[right];

        int result = 0;

        while(left<right){

            if(height[left] < height[right]){
                leftMax = Math.max(height[left],leftMax);
                result = result + leftMax - height[left];
                left++;
            }else{
                rightMax = Math.max(height[right], rightMax);
                result = result + rightMax - height[right];
                right--;
            }
        }
        return result;
    }
}
