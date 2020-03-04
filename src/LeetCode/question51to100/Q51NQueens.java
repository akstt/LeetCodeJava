package LeetCode.question51to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51NQueens {
    // 斜线是否占用
    private boolean[] diagonal_1;
    private boolean[] diagonal_2;
    // 列是否占用
    private boolean[] col;
    // 皇后位置
    private int[] queen;
    // 结果
    private List<List<String>> result;
    // 回溯法
    public List<List<String>> solveNQueens(int n) {
        diagonal_1 = new boolean[n + n - 1];
        diagonal_2 = new boolean[n + n - 1];
        col = new boolean[n];
        queen = new int[n];
        result = new ArrayList<>();
        solveNQueens(n, 0);
        return result;

    }

    // 递归主体
    private void solveNQueens(int n, int index_row) {
        if (index_row == n) {
            addResult(n);
        } else {
            for (int index_col = 0; index_col < n; index_col++) {
                int index_diagonal_1 = index_col - index_row + n - 1;
                int index_diagonal_2 = index_col + index_row;
                if (! (col[index_col] || diagonal_1[index_diagonal_1] || diagonal_2[index_diagonal_2])) {
                    col[index_col] = true;
                    diagonal_1[index_diagonal_1] = true;
                    diagonal_2[index_diagonal_2] = true;
                    queen[index_row] = index_col;
                    solveNQueens(n, index_row + 1);
                    col[index_col] = false;
                    diagonal_1[index_diagonal_1] = false;
                    diagonal_2[index_diagonal_2] = false;
                }
            }
        }
    }

    // 添加结果
    private void addResult(int n){
        List<String> result_1 = new ArrayList<>();
        for (int index_1 = 0; index_1 < n; index_1 += 1){
            StringBuilder row_1 = new StringBuilder();
            for (int index_2 = 0; index_2 < n; index_2 += 1){
                if (index_2 == queen[index_1]){
                    row_1.append('Q');
                }else{
                    row_1.append('.');
                }
            }
            result_1.add(row_1.toString());
        }
        result.add(result_1);
    }


}
