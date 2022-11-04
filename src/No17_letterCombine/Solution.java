package No17_letterCombine;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List<String> res = letterCombinations2("23");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Character, String> hashMap = new HashMap();
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            return res;
        }

        backTracking(res, digits, hashMap,0, new StringBuffer());
        return res;
    }

    public static void backTracking(List<String> res, String digits, HashMap<Character, String> hashMap, int index, StringBuffer cur) {
        if (index == digits.length()) {
            res.add(cur.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = hashMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                cur.append(letters.charAt(i));
                backTracking(res, digits, hashMap, index + 1, cur);
                cur.deleteCharAt(index);
            }
        }
    }

    public static List<String> letterCombinations2(String digits) {
        HashMap<Character, String> hashMap = new HashMap();
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList();
        if (digits == null || digits.length() == 0) return res;

        for (int i = 0; i < digits.length(); i++) {
            String letter = hashMap.get(digits.charAt(i));
            combineQueue(queue, letter);
        }
        for (String s : queue) {
            res.add(s);
        }
        return res;
    }
    public static Queue<String> combineQueue(Queue<String> curQueue, String curLetters) {
        if (curQueue.size() == 0) {
            for (int i = 0; i < curLetters.length(); i++) {
                curQueue.add(curLetters.charAt(i) + "");
            }
        } else {
            int queueSize = curQueue.size();//这是最重要的一步，遍历queue的时候，一定要先把queue的sie记下来，不然在for循环中使用queue.size作为结束条件，会陷入死循环。
            for (int i = 0; i < queueSize; i++) {
                String top = curQueue.poll();
                for (int j = 0; j < curLetters.length(); j++) {
                    curQueue.add(top + curLetters.charAt(j));
                }
            }
        }
        return curQueue;
    }

}
