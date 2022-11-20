package No148_sortLinkList;

import Common.JListNode;

/**
 * 归并排序
 *
 * 挺难的
 */

public class Solution {

    public static void main(String[] args) {

        JListNode head = new JListNode(4);
        JListNode node2 = new JListNode(2);
        JListNode node1 = new JListNode(1);
        JListNode node3 = new JListNode(3);
        head.next = node2;
        node2.next = node1;
        node1.next = node3;

        Solution solution = new Solution();
        solution.sortList(head);

    }

    public JListNode sortList(JListNode head) {
        JListNode res = sort(head, null);
        return res;
    }
    public JListNode sort(JListNode head, JListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        JListNode fast = head;
        JListNode slow = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        JListNode mid = slow;
        JListNode list1 = sort(head, mid);
        JListNode list2 = sort(mid, tail);
        JListNode res = merge(list1, list2);
        return res;
    }

    public JListNode merge(JListNode head1, JListNode head2) {
        JListNode dummy = new JListNode(0);
        JListNode temp = dummy, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp.next = temp1 == null ? temp2 : temp1;
        return dummy.next;
    }

}
