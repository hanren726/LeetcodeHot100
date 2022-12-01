package No347_topKFrequent;

import java.util.*;

public class Solution {
    /**
     * 简单解法，用map统计数据和数据出现的次数
     * map中的数据加入到数组中，降序排序
     * 输出前k个数据
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        DataAndCount[] arr = new DataAndCount[map.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr[index++] = new DataAndCount(entry.getKey(), entry.getValue());
        }
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i].data;
        }
        return res;
    }

    class DataAndCount implements Comparable<DataAndCount> {

        private final int count;
        private final int data;

        DataAndCount(int data, int count) {
            this.count = count;
            this.data = data;
        }

        @Override
        public int compareTo(DataAndCount o) {
            return o.count - this.count;
        }
    }


    /**
     * 优先队列
     * @param nums
     * @param k
     * @return
     */

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+ 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int data = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{data, count});
                }
            } else {
                queue.offer(new int[]{data, count});
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }

    /**
     * 用map统计数据和数据出现的次数
     * map中的数据加入到数组中
     * 快速排序的思路，处理出现次数数组」的前 k 大的值
     *
     * A[i, q-1] A[q+1, j]
     *
     */
}
