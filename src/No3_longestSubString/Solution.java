package No3_longestSubString;

import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        String abc = "abcabcbb";
        System.out.print(lengthOfLongestSubstring(abc)+"");
    }

    public static int lengthOfLongestSubstring(String s) {

        int res = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }
}
