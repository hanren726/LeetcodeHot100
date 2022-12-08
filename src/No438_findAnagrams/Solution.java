package No438_findAnagrams;

import java.util.*;

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/9749/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/
 * 滑动窗口问题
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(solution.findAnagrams(s, p));
    }
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int valid = 0;
        for (char pChar : p.toCharArray()) {
            need.put(pChar, need.getOrDefault(pChar, 0) + 1);
        }
        while (right < s.length()) {
            char cur = s.charAt(right++);
            //加入窗口时，先加window，再比较更新valid
            if (need.get(cur) != null) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (window.get(cur).intValue() == need.get(cur).intValue()) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                //当right-left大于p的长度时，可以开始收缩窗口了
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                //缩小窗口时，先比较更新valid，再移除window
                if (need.get(d) != null) {
                    if (window.get(d).intValue() == need.get(d).intValue()) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return res;
    }
}
