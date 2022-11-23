package No208_trie;

/**
 * https://leetcode.cn/problems/implement-trie-prefix-tree/solutions/1662439/by-lfool-k6hb/
 *
 * 非规则多叉树
 * 每个节点有26个子节点
 *
 * 节点的值仅仅表示从根节点到本节点的路径构成的字符串是否有效而已
 */

public class Solution {
    class TrieNode {
        boolean val;
        TrieNode[] children = new TrieNode[26];
    }

    class Trie {

        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                // char -> int
                int i = c - 'a';
                // 初始化孩子节点
                if (p.children[i] == null) p.children[i] = new TrieNode();
                // 节点下移
                p = p.children[i];
            }
            // 此时 p 指向目标字符串的终点
            p.val = true;
        }

        public boolean search(String word) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                // 路径不存在的情况，直接返回 false
                if (p.children[i] == null) return false;
                p = p.children[i];
            }
            // 路径存在，直接返回该路径的终点处的节点的有效性
            return p.val;
        }

        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (char c : prefix.toCharArray()) {
                int i = c - 'a';
                if (p.children[i] == null) return false;
                p = p.children[i];
            }
            return true;
        }
    }
}
