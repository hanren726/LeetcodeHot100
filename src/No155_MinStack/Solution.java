package No155_MinStack;

import java.util.Map;
import java.util.Stack;

public class Solution {

    /**
     * 这个思路比较粗暴，使用一个栈，每个元素是一个数组，数组里有两个元素，分别为当前元素和当前最小值。、
     * 还有一个思路比这个还要粗暴，使用两个栈，一个栈保存元素，一个栈保存当前最小值，同步操作两个栈
     */
    class MinStack {

        Stack<int[]> stack;
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new int[]{val, val});
            } else {
                stack.push(new int[]{val, Math.min(val, stack.peek()[1])});
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        MinStack2 obj = new MinStack2();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
    }

    static class MinStack2 {

        Stack<Integer> stack;
        int min;

        public MinStack2() {

        }

        public void push(int val) {
            if (val > min) {
                //如果当前值比最小值大，就直接把当前值入栈
                stack.push(val);
            } else {
                //反之，先把之前的最小值（注意是之前的，不是最新的）入栈（这样做的目的是，最上面的值被pop时，还可以记住剩下元素里最小的值），再把当前值入栈，再更新min（供下次使用）
                stack.push(min);
                stack.push(val);
                min = val;
            }
        }

        public void pop() {
            //如果栈顶元素pop后，等于最新的min，则说明min需要更新到之前的，此时min保存在栈顶，pop出来
            //反之，如果栈顶元素pop后，不等于min，则不需要做任何处理，不需要更新min
            if (stack.pop() == min) {
                min = stack.pop();
            }
        }

        public int top() {
            //看push的逻辑，栈顶一定保存着最新的元素，区别只在于栈顶下面，有没有保存之前的最小值。
            return stack.peek();
        }

        public int getMin() {
            //min始终保存着最小值
            return min;
        }
    }

}
