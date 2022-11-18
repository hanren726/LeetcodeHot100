package No139_wordBreak;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(solution.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordDict);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }




    public boolean wordBreak2(String s, List<String> wordDict) {
        return backtrack(s, wordDict, new StringBuilder());
    }

    public boolean backtrack(String s, List<String> wordDict, StringBuilder cur) {
        if (s.equals(cur.toString())) {
            return true;
        } else if (cur.length() > s.length()) {
            return false;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            cur.append(wordDict.get(i));
            boolean res = backtrack(s, wordDict, cur);
            if (res) {
                return true;
            } else {
                cur.delete(cur.length() - wordDict.get(i).length(), cur.length());
            }
        }
        return false;
    }
}
