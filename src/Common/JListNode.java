package Common;

import No2_Plus.Solution;

public class JListNode {
    public int val;
    public JListNode next;

    public JListNode() {
    }

    public JListNode(int val) {
        this.val = val;
    }

    public JListNode(int val, JListNode next) {
        this.val = val;
        this.next = next;
    }
}
