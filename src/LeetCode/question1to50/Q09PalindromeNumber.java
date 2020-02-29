package LeetCode.question1to50;

public class Q09PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        if (x==0){
            return true;
        }
        if (x%10 == 0){
            return false;
        }
        int tempNumber = 0;
        while (tempNumber < x){
            tempNumber = tempNumber *10 + x %10;
            x = x/10;
        }
        return tempNumber == x || tempNumber/10 == x;
    }

    public static void main(String[] args) {
        var a = 123;
        var x = new Q09PalindromeNumber();
        System.out.println(x.isPalindrome(a));
    }
}
