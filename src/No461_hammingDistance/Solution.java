package No461_hammingDistance;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingDistance(1,4));
    }

    /**
     * 传统思路
     * @param x
     * @param y
     * @return
     */
    public int  hammingDistance(int x, int y) {
        StringBuilder strX = new StringBuilder();
        while (x / 2 != 0) {
            strX.insert(0, x % 2);
            x = x / 2;
        }
        strX.insert(0,x);
        StringBuilder strY = new StringBuilder();
        while (y / 2 != 0) {
            strY.insert(0, y % 2);
            y = y / 2;
        }
        strY.insert(0, y);
        int lenX = strX.toString().length();
        int lenY = strY.toString().length();
        if (lenX < lenY) {
            for (int i = 0; i < lenY-lenX; i++) {
                strX.insert(0, "0");
            }
            lenX = lenY;
        } else if (lenX > lenY) {
            for (int i = 0; i < lenX-lenY; i++) {
                strY.insert(0, "0");
            }
        }
        int count = 0;
        for (int i = 0; i < lenX; i++) {
            if (strX.toString().charAt(i) != strY.toString().charAt(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 按位与：n & n-1 的值是 去掉二进制n最右边1的值； 比如 1010 & 1001 = 1000；
     * 用这个可以非常优雅的计算一个数里面的1的个数！
     * 异或：a ^ b，两数异或（不同位为1），剩下二进制为1的就是不同的二进制位
     * @param x
     * @param y
     * @return
     */
    public int  hammingDistance2(int x, int y) {
        int ret = x ^ y;
        int ans = 0;
        while (ret != 0) {
            ret = ret & (ret - 1);
            ans++;
        }
        return ans;
    }
}
