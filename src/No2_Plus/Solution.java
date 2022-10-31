package No2_Plus;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        int plus = 0;
        ListNode cur = res;
        while(l1 != null || l2 != null) {
            int sum = plus;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            plus = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if (plus > 0) {
            cur.next = new ListNode(plus);
        }
        return res.next;
    }
}
