package com.yy.leetcode.unclear;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        //注意比较的技巧
        String result = Arrays.stream(nums).mapToObj(Integer::toString).sorted((c1, c2) -> (c2 + c1).compareTo(c1 + c2)).collect(Collectors.joining());
        if(result.startsWith("0")) return "0";

        return result;
    }

    private static class ReverseComparator
            implements Comparator<String>, Serializable {

        private static final long serialVersionUID = 7207038068494060240L;


        @Override
        public int compare(String c1, String c2) {
            return (c2+c1).compareTo(c1+c2);
        }

        private Object readResolve() { return Collections.reverseOrder(); }

    }
}
