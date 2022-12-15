package No647_countSubstrings;

public class Solution {
    public int countSubstrings(String s) {

        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += expand(s, i, i) + expand(s, i, i + 1);
        }
        return ans;
    }

    public int expand(String s, int left, int right) {
        int ans = 0;
        while (left >= 0 && right <= s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            ans++;
        }
        return ans;
    }

}
