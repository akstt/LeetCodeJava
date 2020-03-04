package LeetCode.question51to100;

public class Q62UniquePaths {


    public int uniquePaths(int m, int n) {
        // 向右 m-1 步， 向下 n-1 步， 然后排列组合
        // 溢出了
//        int result_1 = 1;
//        double result_2 = 1;
//        int num_1 = Math.min(m, n) - 1;
//        int num_2 = m + n - 2;
//        for (; num_1 > 0; num_1 --, num_2--){
//            result_1 *= num_1;
//            result_2 *= num_2;
//        }
//        return (int)result_2 / result_1;
        //动态规划
        int[][] result = new int[n][m];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j ++){
                if (i == 0 || j == 0){
                    result[i][j] = 1;
                }else{
                    result[i][j] = result[i-1][j] + result[i][j-1];
                }
            }
        }
        return result[n-1][m-1];
    }

    public static void main(String[] args) {
        var x = new Q62UniquePaths();
        System.out.println(x.uniquePaths(10, 10));
    }
}
