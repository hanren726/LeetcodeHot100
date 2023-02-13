package offer.No33;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            int[] cnt = new int[26];
            for (int i=0; i<str.length(); i++) {
                cnt[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++) {
                if (cnt[i] != 0) {
                    for (int j=0; j<cnt[i]; j++) {
                        sb.append((char)('a' + i));
                    }
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }


}
