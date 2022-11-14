package No78_subSets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.subsets(nums);
        System.out.println(res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void backTracking(List<List<Integer>> res, List<Integer> cur, int[] nums, int start) {
        res.add(new ArrayList<>(cur));
        //子集问题的选择列表，是上一条选择路径之后的数，i从start开始遍历，保证nums[start]不会再被选择
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backTracking(res, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
