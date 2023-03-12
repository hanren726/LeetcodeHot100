package offer.No100;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        triangle.add(l4);

        System.out.println(new Solution().minimumTotal(triangle));

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size();
        int lastCount = triangle.get(level - 1).size();
        int[][] dp = new int[level][lastCount];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < level; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }
        for (int i = 1; i < level; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }
        for (int i = 1; i < level; i++) {
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lastCount; i++) {
            min = Math.min(min, triangle.get(level - 1).get(i));
        }
        return min;
    }
}
