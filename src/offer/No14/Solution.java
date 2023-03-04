package offer.No14;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "hello";
        String s2 = "ooolleoooleh";
        System.out.printf(solution.checkInclusion(s1, s2)+"");
    }

    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;
        int need = s1.length();
        while(right < s2.length()) {
            char cur = s2.charAt(right);
            if (s1.contains(cur+"")) {
                need--;
                if (need ==0) {
                    return true;
                }
            }
            while(right - left + 1 == s1.length()) {
                char toRemove = s2.charAt(left);
                if (s1.contains(toRemove+"")) {
                    need++;
                }
                left++;
            }
            right++;
        }
        return false;
    }
}
