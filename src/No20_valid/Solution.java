package No20_valid;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.add(cur);
            }
            if (cur == ')') {
                if (stack.size() > 0) {
                    if (stack.pop() != '(') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if (cur == ']') {
                if (stack.size() > 0) {
                    if (stack.pop() != '[') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if (cur == '}') {
                if (stack.size() > 0) {
                    if (stack.pop() != '{') {
                       return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

}
