package No206_reverseLinkedList;

import Common.JListNode;

/**
 * https://leetcode.cn/problems/reverse-linked-list/solutions/36710/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
 *
 * 链表相关题目
 */
public class Solution {
    public JListNode reverseList(JListNode head) {
        JListNode cur = null;
        JListNode pre = head;
        while (pre != null) {
            JListNode temp = pre.next;
            pre.next = cur; //实现反转
            cur = pre; //后移
            pre = temp;
        }
        return cur;
    }

    public JListNode reverseList1(JListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        //递归调用，反转第二个节点往后的链表
        JListNode last = reverseList(head.next);
        // 反转头节点和第二个节点的指向
        head.next.next = head;
        //此时head为尾节点，next需要指向null
        head.next = null;
        return last;
    }
}
