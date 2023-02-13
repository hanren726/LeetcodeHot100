package offer.No34;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[]{"word", "world", "row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(solution.isAlienSorted(words, order));
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            boolean isValid = false;
            for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
                int cur = index[words[i].charAt(j) - 'a'];
                int next = index[words[i + 1].charAt(j) - 'a'];
                if (cur > next) {
                    return false;
                }
                if (cur < next) {
                    isValid = true;
                    break;
                }
            }
            if (!isValid) {
                if (words[i].length() > words[i + 1].length()) {
                    return false;
                }
            }
        }
        return true;
    }

}
