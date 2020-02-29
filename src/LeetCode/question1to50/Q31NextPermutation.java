package LeetCode.question1to50;

import java.util.Arrays;

public class Q31NextPermutation {
    /**
     * 原地修改, 实际上是找到
     * @param nums 数组排列
     */
    public void nextPermutation(int[] nums) {
        for(int i = nums.length-1; i >0; i --){
            if (nums[i-1] < nums[i]){
                reverseArray(nums, i, nums.length-1);
                for (int j = i; j < nums.length; j++){
                    if (nums[j] > nums[i-1]){
                        int numTemp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = numTemp;
                        break;
                    }
                }
                return;
            }
        }
        reverseArray(nums, 0, nums.length-1);
    }

    public void reverseArray(int[] nums, int indexStart, int indexEnd){
        while (indexStart < indexEnd){
            int numTemp = nums[indexStart];
            nums[indexStart] = nums[indexEnd];
            nums[indexEnd] = numTemp;
            indexStart ++;
            indexEnd --;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        var x = new Q31NextPermutation();
        x.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
