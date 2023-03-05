package offer.No81;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrace(candidates, target, 0);

        StringBuilder sb = new StringBuilder();
        sb.delete(sb.length() - 1, sb.length());
        return res;
    }

    public void backtrace(int[] candidates, int target, int start) {
        if (sum(cur) == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (sum(cur) > target) {
            return;
        }
        for (int i=start; i<candidates.length; i++) {
            cur.add(candidates[i]);
            backtrace(candidates, target, i);
            cur.remove(cur.size() - 1);
        }
    }

    public int sum(List<Integer> cur) {
        int sum = 0;
        for (Integer el : cur) {
            sum += el;
        }
        return sum;
    }
}
