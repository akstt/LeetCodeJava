package LeetCode.question1to50;

import java.util.Arrays;

public class Q16ThreeSumClosest {
    /**
     * 先将nums排序，然后使用三个指针，第一个指针index_1遍历数组；后两个指针分别为index_1+1和nums.length - 1,然后搜索符合条件的结果
     * @param nums 输入的整数列数组
     * @param target 逼近的结果
     * @return 相加最接近的结果
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int index_1 = 0, index_2 = 0, index_3 = 0;
        // numTemp1，numTemp2 用于去重
        int numTemp1 = nums[0] -1;
        int numTemp2;
        for (; index_1< nums.length-2; index_1 ++){
            if (nums[index_1] == numTemp1) {
                continue;
            }else{
                numTemp1 = nums[index_1];
            }
            index_2 = index_1 + 1;
            index_3 = nums.length - 1;
            while (index_2 < index_3){
                int threeSum = nums[index_1] + nums[index_2] + nums[index_3];
                if (Math.abs(target - threeSum) < Math.abs(target - result)){
                    result = threeSum;
                }
                if (threeSum == target){
                    return target;
                }else if(threeSum > target){
                    index_3--;
                }else{
                    index_2++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var a = new int[]{1,2,4,8,16,32,64,128};
        var x = new Q16ThreeSumClosest();
        System.out.println(x.threeSumClosest(a, 82));
    }
}
