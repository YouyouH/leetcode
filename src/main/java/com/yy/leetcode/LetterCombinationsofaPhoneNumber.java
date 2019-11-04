package com.yy.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author youyouhuang
 * @create 2019-11-04
 * @desc https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 **/

public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Map<Integer, List<String>> integerListMap = initiallizeMap();
        int length = digits.length();
        if(0 == length){
            return new ArrayList<>();
        }
        for (int i = 0; i < length; i++) {
            String s = String.valueOf(digits.charAt(i));
            if( s.compareTo("2") <0 || s.compareTo("9") >0 ){
                return new ArrayList<>();
            }
            int integer = Integer.parseInt(s);
            List<String> mappings = integerListMap.get(integer);
            if(mappings.isEmpty()){
                return new ArrayList<>();
            }
            List<List<String>> tmp = new ArrayList<>();
            for (List<String> tmpResult : result) {
                for (String mapping : mappings) {
                    ArrayList<String> strings = new ArrayList<>(tmpResult);
                    strings.add(mapping);
                    tmp.add(strings);
                }
            }
            result = tmp;
        }
        return result.stream().map(list -> convertToString(list)).collect(Collectors.toList());
    }

    private String convertToString(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    private Map<Integer, List<String>> initiallizeMap() {
        Map<Integer, List<String>> number2abc = new HashMap<>();
        number2abc.put(2, Arrays.asList("a", "b", "c"));
        number2abc.put(3, Arrays.asList("d", "e", "f"));
        number2abc.put(4, Arrays.asList("g", "h", "i"));
        number2abc.put(5, Arrays.asList("j", "k", "l"));
        number2abc.put(6, Arrays.asList("m", "n", "o"));
        number2abc.put(7, Arrays.asList("p", "q", "r", "s"));
        number2abc.put(8, Arrays.asList("t", "u", "v"));
        number2abc.put(9, Arrays.asList("w", "x", "y", "z"));
        return number2abc;
    }

}
