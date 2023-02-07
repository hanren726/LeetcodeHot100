package offer.No18;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));

    }
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        String news = s.toLowerCase();
        while(left < right) {
            char leftChar = news.charAt(left);
            char rightChar = news.charAt(right);
            if (!isNumOrAlpha(leftChar)) {
                left++;
            } else if (!isNumOrAlpha(rightChar)) {
                right--;
            } else {
                if(leftChar == rightChar) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isNumOrAlpha(char a) {
        if (a >= 'a' && a <= 'z') {
            return true;
        }
        if (a >= 'A' && a <= 'Z') {
            return true;
        }
        if (a >= '0' && a <= '9') {
            return true;
        }
        return false;
    }
}
