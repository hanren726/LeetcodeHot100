package No22_genParenthesis;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        genAll(new char[2 * n], 0, res);
        return res;
    }

    public void genAll(char[] cur, int pos, List<String> result) {

        if (pos == cur.length) {
            if (isValid(cur)) {
                result.add(new String(cur));
            }
        } else {
            cur[pos] = '(';
            genAll(cur, pos + 1, result);
            cur[pos] = ')';
            genAll(cur, pos + 1, result);
        }

    }

    public boolean isValid(char[] cur) {
        int balance = 0;
        for (int i = 0; i < cur.length; i++) {
            if (cur[i] == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    // 左括号数量不大于n，可以放一个左括号；右括号数量小于左括号数量，可以放一个右括号
    public void backtrack(List<String> res, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(res, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(res, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
