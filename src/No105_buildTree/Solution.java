package No105_buildTree;

import Common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *  preIndex记录preOrder的遍历
 *  把inOrder数组用map记录，key是值，value是index
 *
 *  通过preIndex获得当前要摆放的值，在inOrder种拿到所处的index，left～index-1为左子树，index+1～right为右子树
 */

public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;
    int[] inorder;
    int preIndex = 0;

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        Solution solution = new Solution();
        System.out.println(solution.buildTree(preorder, inorder).val);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int index = 0;
        for (int in : inorder) {
            map.put(in, index++);
        }
        TreeNode root = helper(0, inorder.length - 1);
        return root;
    }

    public TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        int rootVal = preorder[preIndex];
        preIndex++;
        int rootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        TreeNode leftNode = helper(left, rootIndex-1);
        TreeNode rightNode = helper(rootIndex + 1, right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
