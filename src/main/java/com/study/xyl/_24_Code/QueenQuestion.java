package com.study.xyl._24_Code;


/**
 * N皇后问题
 */
public class QueenQuestion {
    public static int n;
    public static void solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '*';
            }
        }
        solve(chess, 0);

    }

    private static void solve(char[][] chess, int row) {
        //找到一种符合条件的情况
        if (row == chess.length) {
            //打印
            for (char[] chars : chess) {
                for (int j = 0; j < chars.length; j++) {
                    System.out.print(chars[j] + ", ");
                }
                System.out.println();
            }
            System.out.println();
            n++;
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (valid(chess, row, col)) {
                chess[row][col]  = 'Q';
                solve(chess, row + 1);
                chess[row][col] = '*';
            }
        }
    }

    private static boolean valid(char[][] chess, int row, int col) {
        //判断当前坐标上面有没有皇后
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的左上角有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的右上角有没有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        solveNQueens(8);
        System.out.println(n);
    }

}
