package No437_pathSum;

import Common.TreeNode;

public class Solution {
    /**
     * 深度优先 DFS
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root,  targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, long target) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == target) {
            ret++;
        }
        ret += rootSum(root.left, target - val);
        ret += rootSum(root.right, target - val);
        return ret;
    }


    /**
     * @param root
     * @param targetSum
     * @return
     * 遍历+ DFS
     */
    int count = 0;
    public int pathSum2(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return count;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        dfsNode(root, target, 0); //处理当前root节点
        dfs(root.left, target); //开始递归左子节点
        dfs(root.right, target);//开始递归右子节点
    }

    public void dfsNode(TreeNode root, int target, long sum) {
        if (root == null) {
            return;
        }
        sum = sum + root.val;
        if (sum == target) {
            count++;
        }
        dfsNode(root.left, target, sum);
        dfsNode(root.right, target, sum);
    }
}
