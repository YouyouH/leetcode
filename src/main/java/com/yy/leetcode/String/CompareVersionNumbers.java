package com.yy.leetcode.String;
/**
 * @author youyouhuang
 * @create 2020-04-04
 **/

/**
 * <p>
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 * <p>
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 * <p>
 * . 字符不代表小数点，而是用于分隔数字序列。
 * <p>
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 * <p>
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-version-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] version1Split = version1.split("\\.");
        String[] version2Split = version2.split("\\.");
        int min = Math.min(version1Split.length, version2Split.length);

        for (int i = 0; i < min; i++) {
            Integer integer1 = Integer.valueOf(version1Split[i]);
            Integer integer2 = Integer.valueOf(version2Split[i]);
            if (integer1 > integer2) {
                return 1;
            } else if (integer1 < integer2) {
                return -1;
            }
        }
        if (version1Split.length == version2Split.length) {
            return 0;
        }
        if(version1Split.length > version2Split.length){
            for (int i = min; i <version1Split.length ; i++) {
                if(Integer.valueOf(version1Split[i]) >0){
                    return 1;
                }
            }
        }
        if(version2Split.length > version1Split.length){
            for (int i = min; i <version2Split.length ; i++) {
                if(Integer.valueOf(version2Split[i]) >0){
                    return -1;
                }
            }
        }
        return 0;

    }
}
