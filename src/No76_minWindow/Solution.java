package No76_minWindow;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution solution = new Solution();
        System.out.println(solution.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        int need = t.length();
        int left = 0;
        int right = 0;

        int res = s.length() + 1;

        int start = 0;
        int end = -1;
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (map.containsKey(cur)) {
                if (map.get(cur) > 0) {
                    need -= 1;
                }
                map.put(cur, map.get(cur) - 1);
            }
            while (need == 0) {
                if (res > right - left + 1) {
                    res = right - left + 1;
                    start = left;
                    end = right;
                }

                char toRemove = s.charAt(left);
                if (map.containsKey(toRemove)) {
                    if (map.get(toRemove) >= 0) {
                        need += 1;
                    }
                    map.put(toRemove, map.get(toRemove) +1);
                }
                left += 1;
            }
            right++;
        }
        return s.substring(start, end + 1);
    }
}
