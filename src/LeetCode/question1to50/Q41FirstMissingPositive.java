package LeetCode.question1to50;

public class Q41FirstMissingPositive {
    /**
     *
     * @param nums 未排序的整数数组
     * @return 没有出现的最小的正整数
     */
    public int firstMissingPositive(int[] nums) {
        boolean[] ifExist = new boolean[nums.length + 1];
        for (int num:nums){
            if (num > 0 && num <= nums.length){
                ifExist[num-1] = true;
            }
        }
        for (int i = 0; i < ifExist.length; i++){
            if (! ifExist[i]){
                return i + 1;
            }
        }
        return -1;
    }
}
