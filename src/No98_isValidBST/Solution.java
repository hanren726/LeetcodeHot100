package No98_isValidBST;

import Common.TreeNode;

/**
 *  重点在于保证，root右边所有节点都是比root大的，仅满足比自己的根节点大是不够的
 *  所以递归函数里，需要带上下限
 */

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
    }
}
