package LeetCode.question1to50;

public class Q26RemoveDuplicatesFromSortedArray {
    /**
     *
     * @param nums 需要删除重复项的数组
     * @return 包含没重复数字的前index
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        // numTemp保存当前数字
        // indexTemp为当前没重复数字个数，也是下一个未重复数字需要放置的index
        int numTemp = nums[0];
        int indexTemp = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != numTemp){
                nums[indexTemp++] = nums[i];
                numTemp = nums[i];
            }
        }
        return indexTemp;
    }
}
