package LeetCode.question1to50;

public class Q48RotateImage {
    /**
     *
     * @param matrix 原图像
     */
    public void rotate(int[][] matrix) {
        boolean[][] ifRotate = new boolean[matrix.length][matrix[0].length];
        // double[] center = new double[]{matrix.length/2.0-0.5, matrix[0].length/2.0-0.5};
        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if (ifRotate[i][j]){
                    continue;
                }
                int i1 = i, j1 = j, val1 = matrix[i1][j1];
                while (true){
                    int i2 = j1, j2= matrix.length-1 - i1, val2 = val1;
                    ifRotate[i2][j2] = true;
                    i1 = i2;
                    j1 = j2;
                    val1 = matrix[i1][j1];
                    matrix[i1][j1] = val2;
                    if (i1 == i && j1 == j){
                        break;
                    }
                }

            }
        }

    }
}
