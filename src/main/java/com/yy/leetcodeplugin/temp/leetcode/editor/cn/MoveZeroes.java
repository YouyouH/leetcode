
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-20 14:02:16 
//移动零

public class MoveZeroes{
    public static void main(String[] args) {
         Solution solution = new MoveZeroes().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        /**
         * 双指针，slow指向0，fast往前找不是0的数，然后复制回slow
         * FIXME： 自己做的太复杂了
         */
        int length = nums.length;
        int l = 0;
        int r = 0;
        while (r < length) {
//            System.out.println("l=" + l + " r=" + r);
            if (nums[r] != 0) {
//                System.out.println(nums[l]);
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
            }
            r++;
        }
        //4243000510

//        FIXME： 自己做的太复杂了
//        while (r < length) {
//            while (r < length && nums[r]==0) {r++;}
//            if (r == length) {
//                break;
//            }
//            while (l<length && nums[l]!=0) l++;
//            if (l == length) {
//                break;
//            }
//            while (r < l) {//r不能在l后面 否则没有必要移动
//                r++;
//            }
////            System.out.println("l=" + l + " r=" + r);
//            nums[l] = nums[r];
//            nums[r] = 0;
//            //1 0 0 3 12
//            //1 3 0 0 12

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2592 👎 0
