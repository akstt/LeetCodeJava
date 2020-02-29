package LeetCode.question1to50;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q37SudokuSolver {
    /**
     * @indexEmpty 数组中空缺的位置
     * @numEmpty 空缺的总数
     * @horizontalSet 行包含数字
     * @verticalSet 列包含数字
     * @chunkSet 包含数字
     */
    private int[][] indexEmpty = new int[81][3];
    private int numEmpty = 0;
    private Set[] horizontalSet = new HashSet[9];
    private Set[] verticalSet = new HashSet[9];
    private Set[] chunkSet = new HashSet[9];

    /**
     *
     * @param board 数独数组
     */
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++){
            horizontalSet[i] = new HashSet<Character>();
            verticalSet[i] = new HashSet<Character>();
            chunkSet[i] = new HashSet<Character>();
        }
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                char charTemp = board[i][j];
                int k = i / 3 + j / 3 * 3;
                if (charTemp == '.'){
                    indexEmpty[numEmpty] = new int[]{i, j, k};
                    numEmpty += 1;
                }else{
                    horizontalSet[i].add(charTemp);
                    verticalSet[j].add(charTemp);
                    chunkSet[k].add(charTemp);
                }
            }
        }
        addBoardNum(board, 0);

    }
//
//    public Set<Character> newSet(){
//        Set<Character> setTemp = new HashSet<>();
//        for (int i = 0; i < 9; i ++){
//            setTemp.add((char) (i + '1'));
//        }
//        return setTemp;
//    }

    public boolean addBoardNum(char[][] board, int indexNow){
        if (indexNow == numEmpty){
            return true;
        }
        Set<Character> setTemp = new HashSet<>();
        for (int i = 0; i < 9; i ++){
            setTemp.add((char) (i + '1'));
        }
        setTemp.removeAll(horizontalSet[indexEmpty[indexNow][0]]);
        setTemp.removeAll(verticalSet[indexEmpty[indexNow][1]]);
        setTemp.removeAll(chunkSet[indexEmpty[indexNow][2]]);
        for(char charTemp: setTemp){
            board[indexEmpty[indexNow][0]][indexEmpty[indexNow][1]] = charTemp;
            horizontalSet[indexEmpty[indexNow][0]].add(charTemp);
            verticalSet[indexEmpty[indexNow][1]].add(charTemp);
            chunkSet[indexEmpty[indexNow][2]].add(charTemp);
            if (addBoardNum(board, indexNow + 1)){
                return true;
            }
            horizontalSet[indexEmpty[indexNow][0]].remove(charTemp);
            verticalSet[indexEmpty[indexNow][1]].remove(charTemp);
            chunkSet[indexEmpty[indexNow][2]].remove(charTemp);
        }
        // board[indexEmpty[indexNow][0]][indexEmpty[indexNow][1]] = '.';
        return false;
    }

    public static void main(String[] args) {
        var num1 = new char[]{'5','3','.','.','7','.','.','.','.'};
        var num2 = new char[]{'6','.','.','1','9','5','.','.','.'};
        var num3 = new char[]{'.','9','8','.','.','.','.','6','.'};
        var num4 = new char[]{'8','.','.','.','6','.','.','.','3'};
        var num5 = new char[]{'4','.','.','8','.','3','.','.','1'};
        var num6 = new char[]{'7','.','.','.','2','.','.','.','6'};
        var num7 = new char[]{'.','6','.','.','.','.','2','8','.'};
        var num8 = new char[]{'.','.','.','4','1','9','.','.','5'};
        var num9 = new char[]{'.','.','.','.','8','.','.','7','9'};
        var x = new Q37SudokuSolver();
        char[][] y = new char[][]{num1, num2, num3, num4, num5, num6, num7, num8, num9};

        x.solveSudoku(y);

        System.out.println(Arrays.deepToString(y));
    }
}
