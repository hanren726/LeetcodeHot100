package No538_convertBST;

import Common.TreeNode;

/**
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/solutions/215216/yi-tao-quan-fa-shua-diao-nge-bian-li-shu-de-wen-5/
 * 二叉搜索树：中序遍历的结果是非递减的
 * 那么反过来遍历的话，结果就是非递增的
 *
 * 本题可以理解为：当前节点的最新值 = node.val + 中序遍历后续结点的值
 */

public class Solution {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
