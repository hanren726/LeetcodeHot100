package No394_decodeString;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "10[abcd]";
        System.out.println(solution.decodeString(s));

    }

    int ptr;

    public String getDigits(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))) {
            sb.append(s.charAt(ptr));
            ptr++;
        }
        return sb.toString();
    }
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                String digit = getDigits(s);
                stack.push(digit);
            } else if (Character.isLetter(cur) || cur == '[') {
                stack.push(String.valueOf(cur));
                ptr++;
            } else {
                ++ptr;
                Stack<String> sub = new Stack<>();
                while (!"[".equals(stack.peek())) {
                    sub.push(stack.pop());
                }
                stack.pop();
                int times = Integer.parseInt(stack.pop());
                StringBuilder subStr = new StringBuilder();
                while (!sub.isEmpty()) {
                    subStr.append(sub.pop());
                }
                StringBuilder newStr = new StringBuilder();
                for (int i = 0; i < times; i++) {
                    newStr.append(subStr);
                }
                stack.push(newStr.toString());
            }
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

}
