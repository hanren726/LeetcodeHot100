package offer.No36;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] tokes = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(solution.evalRPN(tokes));

    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(int i=0; i<tokens.length; i++) {
            char cur = tokens[i].charAt(0);
            if (cur >= '0' && cur <= '9') {
                stack.push(cur - '0');
            } else {
                int val = 0;
                int top = stack.pop();
                int top2 = stack.pop();
                if (cur == '+') {
                    val = top2 + top;
                }
                if (cur == '-') {
                    val = top2 - top;
                }
                if (cur == '*') {
                    val = top2 * top;
                }
                if (cur == '/') {
                    val = top2 / top;
                }
                stack.push(val);
            }

        }
        return stack.pop();
    }
}
