package LeetCode.question1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18FourSum {
    /**
     * 可以参考三数和写循环，下面的代码采用递归的方法, 可以得出n数相加的和，想法和三数和相似
     * @param nums 整数数组
     * @param target 相加的目标值
     * @return 可以得到结果的数组
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        // flag为n，当计算四数相加时，为4,flag最小为2
        int flag = 4;
        if (nums.length < flag){
            return new ArrayList<List<Integer>>();
        }
        return fourSum(nums, target, flag-1, 0);

    }

    public List<List<Integer>> fourSum(int[] nums, int target, int flag, int index_start){
        List<List<Integer>> result = new ArrayList<>();
        int numTemp = nums[0] - 1;
        if (flag == 1){
            int index_1 = index_start;
            int index_2 = nums.length -1;
            while (index_1 < index_2){
                if (nums[index_1] + nums[index_1 + 1] > target || nums[index_2] + nums[index_2 - 1] < target){
                    break;
                }
                int sumTwo = nums[index_1] + nums[index_2];
                if (sumTwo > target){
                    index_2--;
                }else if(sumTwo < target){
                    index_1++;
                }else{
                    List<Integer> resultTemp = new ArrayList<>();
                    resultTemp.add(nums[index_1]);
                    resultTemp.add(nums[index_2]);
                    result.add(resultTemp);
                    numTemp = nums[index_1];
                    while (nums[index_1] == numTemp && index_1 < index_2){
                        index_1 ++;
                    }
                }
            }
        }else {
            for (int i = index_start; i < nums.length - flag; i++) {
                if (nums[i] == numTemp){
                    continue;
                }else{
                    numTemp = nums[i];
                }
                List<List<Integer>> resultReturn= fourSum(nums, target - nums[i], flag - 1, i + 1);
                for (List<Integer> result_1:resultReturn){
                    result_1.add(nums[i]);
                }
                result.addAll(resultReturn);

            }
        }
        return result;
    }

    public static void main(String[] args) {
        var x = new Q18FourSum();
        System.out.println(x.fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));;
    }
}
