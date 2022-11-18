package No136_singleNumber;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(solution.singleNumber2(nums));
    }

    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
