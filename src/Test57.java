import java.util.ArrayList;
import java.util.Arrays;


public class Test57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 56小改
        int[][] newItervals = new int[intervals.length + 1][2];
        newItervals[0][0] = newInterval[0];
        newItervals[0][1] = newInterval[1];
        for (int i = 1; i < newItervals.length; i++) {
            newItervals[i][0] = intervals[i-1][0];
            newItervals[i][1] = intervals[i-1][1];
        }

        // 先按照区间起始位置排序
        Arrays.sort(newItervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[newItervals.length][2];
        int idx = -1;
        for (int[] interval: newItervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
//        List<int[]> list = new ArrayList<>();
//        int i = 0;
//        boolean insertFlag = false;
//        for (; i < intervals.length; i++) {
//            if (newInterval[1] < intervals[i][0]) {
//                list.add(newInterval);
//                insertFlag = true;
//                break;
//            }
//            if (newInterval[0] > intervals[i][1]) {
//                list.add(intervals[i]);
//            } else {
//                newInterval[0] = newInterval[0] < intervals[i][0] ? newInterval[0] : intervals[i][0];
//                newInterval[1] = newInterval[1] > intervals[i][1] ? newInterval[1] : intervals[i][1];
//                if (i == intervals.length - 1) {
//                    list.add(newInterval);
//                    insertFlag = true;
//                }
//            }
//        }
//        if (!insertFlag) {
//            list.add(newInterval);
//        }
//        for (int j = i; j < intervals.length; j++) {
//            list.add(intervals[j]);
//        }
//        int[][] res = new int[list.size()][2];
//        for (int j = 0; j < list.size(); j++) {
//            res[j] = list.get(j);
//        }
//        return res;
    }
}
