package LeetCode.question51to100;

public class Q53MaximumSubarray {
    // 分治法解决
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length-1);
    }

    // 递归主体
    private int maxSubArray(int[] nums, int indexStart, int indexEnd){
        if (indexStart == indexEnd){
            return nums[indexStart];
        }else {
            int indexMiddle = (indexStart + indexEnd) / 2;
            int leftMax = maxSubArray(nums, indexStart, indexMiddle);
            int rightMax = maxSubArray(nums, indexMiddle + 1, indexEnd);
            int allMax = addSum(nums, indexStart, indexMiddle, indexEnd);
            int numMax = leftMax > rightMax ? leftMax : rightMax;
            return numMax > allMax ? numMax : allMax;
        }
    }

    // 计算两侧相加的最大值
    private int addSum(int[] nums, int indexStart, int indexMiddle, int indexEnd){
        int leftMax = nums[indexMiddle];
        int numTemp = leftMax;

        for (int indexLeft = indexMiddle - 1; indexLeft >= indexStart; indexLeft --){
            numTemp += nums[indexLeft];
            leftMax = numTemp > leftMax? numTemp:leftMax;
        }
        int rightMax = nums[indexMiddle + 1];
        numTemp = rightMax;
        for (int indexRight = indexMiddle + 2; indexRight <= indexEnd; indexRight ++){
            numTemp += nums[indexRight];
            rightMax = numTemp > rightMax ? numTemp:rightMax;
        }
        return leftMax + rightMax;
    }

    public static void main(String[] args) {
        var x = new Q53MaximumSubarray();
        System.out.println(x.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
