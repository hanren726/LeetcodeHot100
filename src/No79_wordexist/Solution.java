package No79_wordexist;


public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, word,0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board, String word, int index, int x, int y) {
        //index表示当前遍历到单词的第index位
        if (x < 0 || x > board.length - 1) {
            return false;
        }
        if (y < 0 || y > board[0].length - 1) {
            return false;
        }
        if (board[x][y] == '.') {
            return false;
        }
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        } else {
            char temp = board[x][y];
            board[x][y] = '.';
            boolean b = backtrack(board, word, index + 1, x + 1, y)
                    || backtrack(board, word, index + 1, x, y + 1)
                    || backtrack(board, word, index + 1, x - 1, y)
                    || backtrack(board, word, index + 1, x, y - 1);
            board[x][y] = temp;
            return b;
        }
    }
}
