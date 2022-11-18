package No141_hasCycle;

import Common.JListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean hasCycle(JListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        JListNode fast = head.next;
        JListNode slow = head;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next;
            slow = slow.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
        }
        return false;
    }

    public boolean hasCycle2(JListNode head) {
        Set<JListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle3(JListNode head) {
        JListNode fast = head;
        JListNode slow = head;
        //只需要判断fast指针是否先到底就可以了
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
