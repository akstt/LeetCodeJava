package LeetCode.question51to100;

import java.util.Arrays;

public class Q57InsertInterval {

    // 和上一道题差不多
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + 1][2];
        result[0] = newInterval;
        int indexResult = 0;
        int indexIntervals = 0;
        for (; indexIntervals < intervals.length; indexIntervals ++){
            if (intervals[indexIntervals][0] > result[indexResult][1]){
                break;
            } else if (intervals[indexIntervals][1] < result[indexResult][0]){
                result[indexResult + 1] = result[indexResult];
                result[indexResult] = intervals[indexIntervals];
                indexResult ++;
            }else{
                result[indexResult][0] = Math.min(result[indexResult][0], intervals[indexIntervals][0]);
                result[indexResult][1] = Math.max(result[indexResult][1], intervals[indexIntervals][1]);
            }
        }
        for (; indexIntervals < intervals.length; indexIntervals ++){
            result[++indexResult] = intervals[indexIntervals];

        }
        return Arrays.copyOf(result, ++indexResult);
    }
}
