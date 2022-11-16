package No114_flatten;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        dfs(root, res);
        for (int i = 1; i < res.size(); i++) {
            TreeNode pre = res.get(i - 1);
            TreeNode cur = res.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    public void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }


    /**
     * 对于当前节点，如果其左子节点不为空，则在其左子树中找到最右边的节点，
     * 作为前驱节点，将当前节点的右子节点赋给前驱节点的右子节点，然后将当前节点的左子节点赋给当前节点的右子节点，并将当前节点的左子节点设为空。
     * 对当前节点处理结束后，继续处理链表中的下一个节点，直到所有节点都处理结束。
     *
     * @param root
     */

    public void flatten2(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }
}
