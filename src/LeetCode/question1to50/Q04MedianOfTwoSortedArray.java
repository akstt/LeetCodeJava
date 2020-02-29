package LeetCode.question1to50;

public class Q04MedianOfTwoSortedArray {
    // 题目要求时间复杂度为O(log(m + n))，使用二分法
    // 二分法寻找较短列表中中位数的位置，时间复杂度应该为O(log(min(m, n)))
    // 空间复杂度O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int indexMedian = (nums1.length + nums2.length + 1) / 2;
        if (nums1.length > nums2.length) {
            int[] numsTemp = nums2;
            nums2 = nums1;
            nums1 = numsTemp;
        }
        if (nums1.length == 0){
            if (nums2.length % 2 == 1){
                return nums2[indexMedian-1];
            }else{
                return (nums2[indexMedian-1] + nums2[indexMedian])/2.0;
            }
        }
        int indexStart = 0;
        int indexEnd = nums1.length;
        while (true) {
            int index1 = (indexStart + indexEnd) / 2;
            int index2 = indexMedian - index1;
            if (index1 > 0 && nums1[index1 - 1] > nums2[index2]) {
                indexEnd = index1 - 1;
            } else if (index1 < nums1.length && nums1[index1] < nums2[index2 - 1]) {
                indexStart = index1 + 1;
            } else {
                int numLeft;
                if (index1 == 0) {
                    numLeft = nums2[index2 - 1];
                } else if (index2 == 0) {
                    numLeft = nums1[index1 - 1];
                } else {
                    numLeft = nums1[index1 - 1] > nums2[index2 - 1] ? nums1[index1 - 1] : nums2[index2 - 1];
                }
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return numLeft;
                }
                int numRight;
                if (index2 == nums2.length) {
                    numRight = nums1[index1];
                } else if (index1 == nums1.length) {
                    numRight = nums2[index2];
                } else {
                    numRight = nums1[index1] < nums2[index2] ? nums1[index1] : nums2[index2];
                }
                return (numLeft + numRight)/2.0;
            }

        }
    }

    public static void main(String[] args) {
        var x = new Q04MedianOfTwoSortedArray();
        var nums1 = new int[]{2,3,4,5};
        var nums2 = new int[]{1};
        System.out.println(x.findMedianSortedArrays(nums1, nums2));
    }
}