package algorithm;

public class T12_ExistInMatrix {    //12.矩阵中的路径
    public boolean exist(char[][] board, String word){
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                if(dfs(board, words, i, j, 0))  return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, char[]words, int i, int j, int index){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[index]) return false;
        if(index == words.length - 1) return true;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean res = dfs(board, words, i + 1, j, index + 1) || dfs(board, words, i - 1, j, index + 1)
                || dfs(board, words, i, j + 1, index + 1) || dfs(board, words, i, j - 1, index + 1);
        board[i][j] = temp;
        return res;
    }
}
