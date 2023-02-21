package offer.No58;

import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        TreeSet<int[]> booked = new TreeSet<int[]>((a, b) -> a[0] - b[0]);
        System.out.println(new Solution().book(10, 15, booked));
        System.out.println(new Solution().book(17, 30, booked));
        System.out.println(new Solution().book(16, 18, booked));
    }

    public boolean book(int start, int end, TreeSet<int[]> booked) {
        if (booked.isEmpty()) {
            booked.add(new int[]{start, end});
            return true;
        }
        int[] tmp = {end, 0};
        int[] arr = booked.ceiling(tmp);
        if (arr == booked.first()) {
            booked.add(new int[]{start, end});
            return true;
        }
        int[] low = booked.lower(tmp);
        if (low != null && low[1] <= start) {
            booked.add(new int[]{start, end});
            return true;
        }
        return false;
    }
}
