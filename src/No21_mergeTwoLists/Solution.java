package No21_mergeTwoLists;

import Common.JListNode;

public class Solution {

    public JListNode mergeTwoLists(JListNode list1, JListNode list2) {

        JListNode head = new JListNode(0);
        JListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return head.next;
    }
}
