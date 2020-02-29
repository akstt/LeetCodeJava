package LeetCode.question1to50;

public class Q27RemoveElement {
    /**
     *
     * @param nums 需要删除元素的数组
     * @param val 需要删除的元素
     * @return 删除元素后剩余元素的数目
     */
    public int removeElement(int[] nums, int val) {
        // indexTemp为当前元素的数目，也是下一个不需要删除的元素需要放置的index
        int indexTemp = 0;
        for (int num:nums){
            if (num != val){
                nums[indexTemp++] = num;
            }
        }
        return indexTemp;
    }
}
