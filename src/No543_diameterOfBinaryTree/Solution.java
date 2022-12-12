package No543_diameterOfBinaryTree;

import Common.TreeNode;

public class Solution {

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = depth(root.left);
        int R = depth(root.right);
        if (L + R > max) {
            max = L + R;
        }
        return Math.max(L, R) + 1;
    }
}
