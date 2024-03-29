package offer.No21;

import java.util.List;

public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        int n = 4;
        Solution solution = new Solution();
        ListNode res = solution.removeNthFromEnd(node1, n);
        System.out.println(res.val);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = head;
        ListNode left = head;
        ListNode right = head;
        for(int i=1; i<n; i++) {
            right = right.next;
        }
        while(right.next.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
