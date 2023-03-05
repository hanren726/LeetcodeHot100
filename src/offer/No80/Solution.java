package offer.No80;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> res = new ArrayList();
    List<Integer> cur = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combine(4, 2);
        for (List<Integer> el : res) {
            for (Integer i : el) {
                System.out.printf(i+",");
            }
            System.out.println("=====");
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return res;
    }

    public void backtrack(int n, int k, int start) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
        }
        for (int i = start; i <= n; i++) {
            cur.add(i);
            backtrack(n, k, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
