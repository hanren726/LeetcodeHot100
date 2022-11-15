package No96_numTrees;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 *
 */
public class Solution {

    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1; //空二叉树也是二叉搜索树
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //以j为根结点，左边是 j-1 个数，右边是 i-j 个数
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
