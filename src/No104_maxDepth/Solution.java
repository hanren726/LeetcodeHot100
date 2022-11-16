package No104_maxDepth;

import Common.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 *
 * 方法一：深度优先，递归
 * 方法二：广度优先，二叉树层序遍历，求层数
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return max(root.left, root.right) + 1;
    }

    public int max(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return 0;
        } else if (left == null) {
            return max(right.left, right.right) + 1;
        } else if (right == null) {
            return max(left.left, left.right) + 1;
        } else {
            return Math.max(max(right.left, right.right), max(left.left, left.right)) + 1;
        }
    }
}
