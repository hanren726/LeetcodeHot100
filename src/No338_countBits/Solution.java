package No338_countBits;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int bit : solution.countBits(5)) {
            System.out.println(bit);
        }

        System.out.println(Integer.bitCount(5));

    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i < n+1; i++) {
            int cur = i;
            int count = 0;
            while (cur /2 != 0) {
                if (cur % 2 == 1) {
                    count++;
                }
                cur = cur / 2;
            }
            res[i] = count + 1;
        }
        return res;
    }
}
