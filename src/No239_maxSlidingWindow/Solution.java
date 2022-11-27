package No239_maxSlidingWindow;

import java.util.LinkedList;

/**
 *  1 3 -1 2 0 3 6 7
 *
 * 双端队列存放下标,这样做比较方便一些
 * 遍历元素   队列        L      R       res
 *  1         0
 *  2         1
 *  -1        1 2       0      2       [3]
 *  2         1 3       1      3       [3, 3]
 *  0         1 3 4     2      4 (这时L大于队首，要移除)
 *  0         3 4       2      4       [3, 3, 2]
 *  3         5         3      5       [3, 3, 2, 3]
 *  6         6         4      6       [3, 3, 2, 3, 6]
 *  7         7         5      7       [3, 3, 2, 3, 6, 7]
 */

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        LinkedList<Integer> queue = new LinkedList<>();

        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {

            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);

            int left = i - k + 1;
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }
            if (i + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
