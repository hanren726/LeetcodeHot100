package No49_groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 相同字母组成的单词，经过排序后应该是完全一致的，用这个排序后的单词做map的key，对应的原单词组成的list做value
 */
public class Solution {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> list = map.get(order(strs[i]));
            if (list == null) {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                map.put(order(strs[i]), newList);
            } else {
                list.add(strs[i]);
            }
        }
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }

        return res;
    }

    public String order(String str) {
        int n = str.length();
        char[] arr = str.toCharArray();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    char temp = arr[j] ;
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
        return new String(arr);
    }

}
