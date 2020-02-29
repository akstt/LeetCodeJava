package LeetCode.question1to50;

public class Q29DivideTwoIntegers {
    /**
     *
     * @param dividend 被除数
     * @param divisor 除数
     * @return 结果
     */
    public int divide(int dividend, int divisor) {
        int result = divide(-Math.abs(dividend), -Math.abs(divisor), -1);
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)){
            if (result == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }
            return -result;
        }
        return result;
    }

    /**
     * @param dividend 被除数
     * @param divisor 除数
     * @param num 除数倍数
     * @return 结果
     */
    public int divide(int dividend, int divisor, int num){
        if (num == -1 && divisor < dividend){
            return 0;
        }else if (divisor > dividend) {
            dividend -= divisor;
            if (divisor > dividend){
                return num + divide(dividend, divisor << 1, num << 1);
            }else{
                return num + divide(dividend, divisor, num);
            }
        }else if (divisor < dividend){
            return divide(dividend, divisor >> 1, num >> 1);
        }else{
            return num;
        }
    }

    public static void main(String[] args) {
        var x = new Q29DivideTwoIntegers();
        System.out.println(x.divide(5, 2));
    }
}
