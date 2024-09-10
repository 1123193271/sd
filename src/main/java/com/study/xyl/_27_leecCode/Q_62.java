package com.study.xyl._27_leecCode;

/**
 * @author 11231
 * @date 2024/9/10 17:26
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 */
public class Q_62 {

    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        } else {
            return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        }
    }

    public static int uniquePathsNoRecursive(int m, int n) {
        int[][] intArray = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    intArray[i][j] = 1;
                } else {
                    intArray[i][j] = intArray[i-1][j] + intArray[i][j-1];
                }
            }
        }
        return intArray[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsNoRecursive(3, 7));
    }
}
