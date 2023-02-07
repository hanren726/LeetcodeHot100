package offer.No15;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = -1;
        int left = 0;
        int right = 0;
        int n = s.length();
        int need = t.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }
        while(right < n) {
            char cur = s.charAt(right);
            if (map.containsKey(cur)) {
                if (map.get(cur) > 0) {
                    need--;
                }
                map.put(cur, map.get(cur) - 1);
            }
            while(need == 0) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }
                char toRemove = s.charAt(left);
                if (map.containsKey(toRemove)) {
                    if (map.get(toRemove) >= 0) {
                        need++;
                    }
                    map.put(toRemove, map.get(toRemove) + 1);
                }
            }
            right++;
        }
        return s.substring(minLeft, minRight+ 1);
    }
}
