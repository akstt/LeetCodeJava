package LeetCode.question51to100;

public class Q55JumpGame {
    // 记录当前最远到达距离，判断是否能到达最后
    public boolean canJump(int[] nums) {
        int indexResult = nums[0];
        int indexNow = 1;
        while (indexNow <= indexResult && indexResult < nums.length-1){
            indexResult = Math.max(indexResult, indexNow + nums[indexNow++]);
        }
        return (indexResult >= nums.length-1);
    }
}
