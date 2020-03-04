package LeetCode.question51to100;

import java.util.ArrayList;
import java.util.List;

public class Q59SpiralMatrixTwo {
    // 把54题改改
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int indexRowStart = 0;
        int indexRowEnd = n-1;

        int indexColStart = 0;
        int indexColEnd = n-1;

        int num = 1;
        while (indexColStart <= indexColEnd && indexRowStart <= indexRowEnd){
            for (int indexCol = indexColStart ; indexCol <= indexColEnd; indexCol ++){
                result[indexRowStart][indexCol] = num++;
            }
            indexRowStart ++;
            for (int indexRow = indexRowStart; indexRow <= indexRowEnd; indexRow ++){
                result[indexRow][indexColEnd] = num++;
            }
            indexColEnd --;
            if (indexColStart  > indexColEnd || indexRowStart > indexRowEnd){
                break;
            }
            for (int indexCol = indexColEnd; indexCol >= indexColStart; indexCol--){
                result[indexRowEnd][indexCol] = num++;
            }
            indexRowEnd --;
            for (int indexRow = indexRowEnd; indexRow >= indexRowStart; indexRow --){
                result[indexRow][indexColStart] = num++;
            }
            indexColStart ++;
        }
        return result;
    }
}
