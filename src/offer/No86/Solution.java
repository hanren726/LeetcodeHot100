package offer.No86;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "google";
        String[][] res = solution.partition(a);

        for (String[] re : res) {
            for (String s : re) {
                System.out.println(s);
            }
            System.out.println("===");
        }

    }

    List<List<String>> res = new ArrayList<>();
    List<String> cur = new ArrayList<>();

    public String[][] partition(String s) {
        backtrace(s, 0);
        String[][] resArr = new String[res.size()][];
        int index = 0;
        for (List<String> el : res) {
            String[] cur = new String[el.size()];
            resArr[index++] = el.toArray(cur);
        }

        return resArr;
    }

    public void backtrace(String s, int start) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isHuiWen(s, start, i)) {
                cur.add(s.substring(start, i+1));
            } else {
                continue;
            }
            backtrace(s, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

    public boolean isHuiWen(String s, int i, int j) {
        int left = i;
        int right = j;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
