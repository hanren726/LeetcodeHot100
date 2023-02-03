package offer.No2;


public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.addBinary("1", "1");
        System.out.println(res);

    }
    public String reverse(String str) {
        StringBuilder res = new StringBuilder();
        int index = str.length() - 1;
        while (index >= 0) {
            res.append(str.charAt(index--));
        }
        return res.toString();
    }

    public String addBinary(String a, String b) {
        String a1 = reverse(a);
        String b1 = reverse(b);
        StringBuilder sb = new StringBuilder();
        int plus = 0;
        int index = 0;
        while (index < a1.length() || index < b1.length()) {
            int aInt = 0;
            if (index < a1.length()) {
                char aCur = a1.charAt(index);
                aInt = aCur - '0';
            }
            int bInt = 0;
            if (index < b1.length()) {
                char bCur = b1.charAt(index);
                bInt = bCur - '0';
            }
            int cur = (aInt + bInt + plus) % 2;
            plus = (aInt + bInt + plus) / 2;
            sb.append(cur);
            index++;
        }
        if (plus > 0) {
            sb.append(plus);
        }

        return reverse(sb.toString());
    }
}
