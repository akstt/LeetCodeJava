package LeetCode.question1to50;

public class Q50Pow {
    /**
     *
     * @param x 底数
     * @param n 次幂
     * @return pow(x, n)
     */
    public double myPow(double x, int n) {
        double result = 1;
        if (n == 0){
            return result;
        }
        if (n < 0){
            x = 1/x;
        }else{
            n = -n;
        }
        double[] xPow = new double[32];
        int indexXPow = 0, nMultiple = -1;
        while (nMultiple >= n){
            xPow[indexXPow] = x;
            x *= x;
            if (nMultiple < -1073741824){
                break;
            }
            nMultiple *= 2;
            indexXPow += 1;

        }
        for (int i = indexXPow; i >= 0; i--){
            if (nMultiple >= n){
                n -= nMultiple;
                result *= xPow[i];
            }
            nMultiple /= 2;

        }
        return result;
    }

    public static void main(String[] args) {
        var x = new Q50Pow();
        System.out.println(x.myPow(1.00000, -2147483648));
    }
}
