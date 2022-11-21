package No160_getIntersectionNode;

import Common.JListNode;

public class Solution {
    public JListNode getIntersectionNode(JListNode headA, JListNode headB) {
        JListNode curA = headA;
        while (curA != null) {
            JListNode curB = headB;
            while (curB != null) {
                if (curA == curB) {
                    return curA;
                }
                curB = curB.next;
            }
            curA = curA.next;
        }
        return null;
    }

    /**
     * 这个思路很绝，自己在纸上画一下
     * 让headA和headB一直往前走，如果走到尾部，headA从headB开始走，headB从headA开始走，
     * 这样如果有交点，一定会相遇，否则都走向null
     * A:a + m B: b + m
     * a+m+b+m = b+m+a+m => a+m+b=b+m+a 在m位置相遇
     * @param headA
     * @param headB
     * @return
     */
    public JListNode getIntersectionNode2(JListNode headA, JListNode headB){
        if (headA == null || headB == null) {
            return null;
        }
        JListNode curA = headA;
        JListNode curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}
