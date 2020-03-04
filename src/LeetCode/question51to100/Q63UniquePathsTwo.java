package LeetCode.question51to100;

public class Q63UniquePathsTwo {
    // 动态规划
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        obstacleGrid[0][0] = 1;
        // 处理边界
        for (int i = 1; i < obstacleGrid.length; i ++){
            if (obstacleGrid[i-1][0] == 1 && obstacleGrid[i][0] == 0){
                obstacleGrid[i][0] = 1;
            }else{
                obstacleGrid[i][0] = 0;
            }
        }
        for (int i = 1; i < obstacleGrid[0].length; i ++){
            if (obstacleGrid[0][i-1] == 1 && obstacleGrid[0][i] == 0){
                obstacleGrid[0][i] = 1;
            }else{
                obstacleGrid[0][i] = 0;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i ++){
            for (int j = 1; j < obstacleGrid[0].length; j ++){
                if (obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = 0;
                }else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }

        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        var x= new Q63UniquePathsTwo();
        x.uniquePathsWithObstacles(new int[][]{new int[]{0, 0, 0}, new int[]{0, 1, 0}, new int[]{0, 0, 0}});
    }
}
