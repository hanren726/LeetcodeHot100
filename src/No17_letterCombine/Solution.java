package No17_letterCombine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<String> res = letterCombinations("234");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Character, String> hashMap = new HashMap();
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            return res;
        }

        backTracking(res, digits, hashMap,0, new StringBuffer());
        return res;
    }

    public static void backTracking(List<String> res, String digits, HashMap<Character, String> hashMap, int index, StringBuffer cur) {
        if (index == digits.length()) {
            res.add(cur.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = hashMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                cur.append(letters.charAt(i));
                backTracking(res, digits, hashMap, index + 1, cur);
                cur.deleteCharAt(index);
            }
        }
    }
}
