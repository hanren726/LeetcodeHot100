package offer.No41;

import Common.TreeNode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        node1.left = node2;
//        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;
//        Solution solution = new Solution();
//        System.out.println(solution.serialize(node1));


        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> quaeue = new LinkedList<>();
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return reserialize(root, "");
    }

    public String reserialize(TreeNode root, String str) {
        if (root == null) {
            str += "No,";
        } else {
            str += String.valueOf(root.val) + ",";
            str = reserialize(root.left, str);
            str = reserialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(arr));
        return redeserialize(dataList);
    }

    public TreeNode redeserialize(List<String> data) {
        if (data.get(0).equals("No")) {
            data.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(data.get(0)));
        data.remove(0);
        root.left = redeserialize(data);
        root.right = redeserialize(data);
        return root;
    }
}
