package No142_detectCycle;

import Common.JListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public JListNode detectCycle(JListNode head) {
        Set<JListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }

    public JListNode detectCycle2(JListNode head) {
        JListNode fast = head;
        JListNode slow = head;
        while (fast != null) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                JListNode first = head;
                while (first != slow) {
                    first = first.next;
                    slow = slow.next;
                }
                return first;
            }
        }
        return null;
    }
}
