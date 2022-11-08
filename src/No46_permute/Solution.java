package No46_permute;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = permute(nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backTracking(res, new ArrayList<>(), nums,visited, 0);
        return res;
    }

    public static void backTracking(List<List<Integer>> res, List<Integer> cur, int[] nums, int[] visited, int start) {
        if (start == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            cur.add(nums[i]);
            backTracking(res, cur, nums, visited, start + 1);
            cur.remove(cur.size() - 1);
            visited[i] = 0;
        }
    }


}
