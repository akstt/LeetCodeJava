package LeetCode.question1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15ThreeSum {
    /**
     * 先将nums排序，然后使用三个指针，第一个指针index_1遍历数组；后两个指针分别为index_1+1和nums.length - 1,然后搜索符合条件的结果
     * @param nums 输入的整数列数组
     * @return 列表，元素为相加结果为0的列表
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
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
            if (nums[index_1] > 0){
                break;
            }
            index_2 = index_1 + 1;
            index_3 = nums.length - 1;
            while (index_2 < index_3){
                if (nums[index_1] + nums[index_2] + nums[index_2 + 1] > 0){
                    break;
                }
                if (nums[index_1] + nums[index_3] + nums[index_3 - 1] < 0){
                    break;
                }
                int threeSum = nums[index_1] + nums[index_2] + nums[index_3];
                if (threeSum == 0){
//                    List<Integer> result_1 = new ArrayList<Integer>();
//                    result_1.add(nums[index_1]);
//                    result_1.add(nums[index_2]);
//                    result_1.add(nums[index_3]);
                    result.add(Arrays.asList(nums[index_1], nums[index_2], nums[index_3]));
                    numTemp2 = nums[index_2];
                    while (numTemp2 == nums[index_2] && index_2 < index_3){
                        index_2 ++;
                    }
                }else if(threeSum > 0){
                    index_3--;
                }else{
                    index_2++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var a = new int[]{-1, 0, 1, 2, -1, -4};
        var x = new Q15ThreeSum();
        System.out.println(x.threeSum(a));
    }
}
