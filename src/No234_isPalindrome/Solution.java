package No234_isPalindrome;

import Common.JListNode;

import java.util.Stack;

public class Solution {
    public boolean isPalindrome(JListNode head) {
        Stack<JListNode> stack = new Stack<>();
        JListNode cur = head;
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (stack.pop().val != head.val) {
                return false;
            } else {
                head = head.next;
            }
        }
        return true;
    }

    /**
     * 进阶：只用O（1）空间复杂度
     *
     * 1.计算链表长度
     * 2.后半部分链表反转
     * 3.两端开始遍历
     */

    public boolean isPalindrome2(JListNode head){
        JListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        JListNode cur = head;
        for (int i = 0; i < count / 2; i++) {
            cur = cur.next;
        }
        JListNode tail = reverse(cur);
        while (tail != null && head != null && tail != head) {
            if (tail.val != head.val) {
                return false;
            } else {
                tail = tail.next;
                head = head.next;
            }
        }
        return true;
    }

    public JListNode reverse(JListNode head) {
        JListNode cur = null;
        JListNode pre = head;
        while (pre != null) {
            JListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }
}
