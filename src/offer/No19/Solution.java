package offer.No19;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome("abc"));

    }

    public boolean validPalindrome(String s) {
        if (isPalind(s)) {
            return true;
        }
        for(int i=0; i<s.length(); i++) {
            if (isPalind(s.substring(i+1))) {
                return true;
            }
        }
        return false;
    }

    public boolean isPalind(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
