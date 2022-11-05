package No19_removeNthFromEnd;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        //重要知识点：如何记住头结点，在头节点的前面再加一个结点
        ListNode res = new ListNode(0, head);
        ListNode newCur = res;
        for (int i = 0; i < count - n; i++) {
            newCur = newCur.next;
        }
        newCur.next = newCur.next.next;

        return res.next;
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode yummy = new ListNode(0, head);
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = yummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        return yummy.next;
    }

}
