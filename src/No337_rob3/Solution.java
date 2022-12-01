package No337_rob3;

import Common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * f(o) 表示选择o节点，o节点子树没选择节点值总和的 最大值
 * g(o) 表示不选择o节点，o节点子树没选择节点值总和的 最大值
 *
 * o被选中，f(o) = g(o.left) + g(o.right)
 * o不被选中，左子节点被选中和不被选中情况下的较大值 + 右子节点被选中和不被选中情况下的较大值
 * g(o) = max{f(o.left), g(o.left)} + max{f(o.right), g(o.right)}
 *
 * dfs:深度优先搜索
 * 二叉树的后序遍历，从叶子节点开始往根节点遍历
 */
public class Solution {
    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<>();
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0))
                + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }

}
