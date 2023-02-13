package offer.No20;


public class Solution {

    public int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len-1][len-1];
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-1; j++) {
                if (j > 0) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] + 1 : dp[i + 1][j - 1];
                }
            }
        }
        return dp[0][len - 1];
    }

}
