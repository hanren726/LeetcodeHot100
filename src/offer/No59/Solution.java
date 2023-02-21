package offer.No59;

import java.util.PriorityQueue;

public class Solution {

    PriorityQueue<Integer> pq;
    int k;

    public static void main(String[] args) {
        Solution solution = new Solution(3, new int[]{4, 5, 8, 2});
        solution.add(3);
    }

    public Solution(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
