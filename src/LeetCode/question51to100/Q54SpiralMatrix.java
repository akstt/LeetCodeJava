package LeetCode.question51to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q54SpiralMatrix {
    // 跟着转就好了
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int indexRowStart = 0;
        int indexRowEnd = matrix.length-1;
        if (indexRowEnd <0){
            return result;
        }
        int indexColStart = 0;
        int indexColEnd = matrix[0].length-1;

        while (indexColStart <= indexColEnd && indexRowStart <= indexRowEnd){
            for (int indexCol = indexColStart ; indexCol <= indexColEnd; indexCol ++){
                result.add(matrix[indexRowStart][indexCol]);
            }
            indexRowStart ++;
            for (int indexRow = indexRowStart; indexRow <= indexRowEnd; indexRow ++){
                result.add(matrix[indexRow][indexColEnd]);
            }
            indexColEnd --;
            if (indexColStart  > indexColEnd || indexRowStart > indexRowEnd){
                break;
            }
            for (int indexCol = indexColEnd; indexCol >= indexColStart; indexCol--){
                result.add(matrix[indexRowEnd][indexCol]);
            }
            indexRowEnd --;
            for (int indexRow = indexRowEnd; indexRow >= indexRowStart; indexRow --){
                result.add(matrix[indexRow][indexColStart]);
            }
            indexColStart ++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[2][2];
        for(int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                matrix[i][j] = i * 2 + j + 1;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        var x = new Q54SpiralMatrix();
        System.out.println(x.spiralOrder(matrix));
    }
}
