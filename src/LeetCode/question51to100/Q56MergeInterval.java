package LeetCode.question51to100;

import java.awt.image.IndexColorModel;
import java.util.Arrays;

public class Q56MergeInterval {
    // 先排序，然后判断下个数组的开始是否小于等于上个数组的结束
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return intervals;
        }
        Arrays.sort(intervals, (x1, x2) -> {
            if (x1[0] > x2[0]){
                return 1;
            }else if (x1[0] < x2[0]){
                return -1;
            }else{
                return 0;
            }
        });
        int indexScope = 0;
        // 修改原数组
        for (int index_1 = 1; index_1 < intervals.length; index_1 ++){
            if (intervals[index_1][0] <= intervals[indexScope][1]){
                intervals[indexScope][1] = Math.max(intervals[indexScope][1], intervals[index_1][1]);
            }
            else{
                intervals[++indexScope] = intervals[index_1];
            }
        }

        return Arrays.copyOf(intervals, indexScope + 1);
    }

    public static void main(String[] args) {
        int[][] x = new int[][]{new int[]{1,4}, new int[]{4,5}};
        var a = new Q56MergeInterval();
        var b = new int[][]{};
        System.out.println(Arrays.deepToString(a.merge(x)));
    }
}
