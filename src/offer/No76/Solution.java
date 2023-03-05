package offer.No76;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] array = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        Solution solution = new Solution();
        System.out.printf(solution.quickSort(array, 2)+"");
        List<Integer> list = new ArrayList<>();
        Collections.sort(list);
    }

    public int quickSort(int[] arr, int k) {
         return quick2(arr, 0, arr.length - 1, arr.length - k);
    }

    public int quick(int[] arr, int start, int end, int pos) {
        if (end >= start) {
            int base = arr[start];
            int left = start;
            int right = end;
            while (left < right) {
                while (left < right && arr[right] > base) {
                    right--;
                }
                if (left < right) {
                    arr[left] = arr[right];
                    left++;
                }
                while (left < right && arr[left] < base) {
                    left++;
                }
                if (left < right) {
                    arr[right] = arr[left];
                    right--;
                }
            }
            arr[left] = base;
            if (left == pos) {
                return arr[left];
            } else if (left < pos) {
                return quick(arr, left + 1, end, pos);
            } else {
                return quick(arr, start, left - 1, pos);
            }
        }
        return 0;
    }


    public int quick2(int[] arr, int start, int end, int pos) {
        if (end >= start) {
            int base = arr[start];
            int left = start;
            int right = end;
            while (left < right) {
                while (left < right && arr[right] >= base) {
                    right--;
                }
                while (left < right && arr[left] <= base) {
                    left++;
                }
                if (left < right) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
            }
            arr[start] = arr[left];
            arr[left] = base;
            if (left == pos) {
                return arr[left];
            } else if (left < pos) {
                return quick(arr, left + 1, end, pos);
            } else {
                return quick(arr, start, left - 1, pos);
            }
        }
        return 0;
    }
}
