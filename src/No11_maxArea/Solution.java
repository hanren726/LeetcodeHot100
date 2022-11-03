package No11_maxArea;

public class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(a));
    }

    public static int maxArea(int[] height) {

        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                max = Math.max(max, (height[i]) * (j - i));
                i++;
            } else {
                max = Math.max(max, (height[j]) * (j - i));
                j--;
            }
        }
        return max;
    }
}
