package LeetCode.question1to50;

public class Q36ValidSudoku {
    /**
     *
     * @param board 数独列表
     * @return 是否满足数独条件
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] horizontalArray = new boolean[9][9];
        boolean[][] verticalArray = new boolean[9][9];
        boolean[][] chunkArray = new boolean[9][9];
        // System.out.println(Arrays.deepToString(horizontalArray));
        for (int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j ++){
                char numChar = board[i][j];
                if (numChar=='.'){

                    continue;

                }
                int num = numChar - 49;
                int k = i / 3 + j / 3 * 3;

                if(horizontalArray[i][num] || verticalArray[j][num] || chunkArray[k][num]){
                    return false;
                }else{
                    horizontalArray[i][num] = true;
                    verticalArray[j][num] = true;
                    chunkArray[k][num] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var x = new Q36ValidSudoku();
        x.isValidSudoku(new char[3][3]);
    }
}
