package LeetCode.question51to100;

import java.util.ArrayList;
import java.util.List;

//在上道题基础上改一改就好了
public class Q52NQueensTwo {
    // 斜线是否占用
    private boolean[] diagonal_1;
    private boolean[] diagonal_2;
    // 列是否占用
    private boolean[] col;
    // 结果
    private int result = 0;
    // 回溯法
    public int totalNQueens(int n) {
        diagonal_1 = new boolean[n + n - 1];
        diagonal_2 = new boolean[n + n - 1];
        col = new boolean[n];
        solveNQueens(n, 0);
        return result;

    }

    // 递归主体
    private void solveNQueens(int n, int index_row) {
        if (index_row == n) {
            result ++;
        } else {
            for (int index_col = 0; index_col < n; index_col++) {
                int index_diagonal_1 = index_col - index_row + n - 1;
                int index_diagonal_2 = index_col + index_row;
                if (! (col[index_col] || diagonal_1[index_diagonal_1] || diagonal_2[index_diagonal_2])) {
                    col[index_col] = true;
                    diagonal_1[index_diagonal_1] = true;
                    diagonal_2[index_diagonal_2] = true;
                    solveNQueens(n, index_row + 1);
                    col[index_col] = false;
                    diagonal_1[index_diagonal_1] = false;
                    diagonal_2[index_diagonal_2] = false;
                }
            }
        }
    }
}
