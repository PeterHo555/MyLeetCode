import java.util.Arrays;
import java.util.Comparator;

public class Test435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // 根据每个区间的末尾元素排序，此处末尾为第1个
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 若此区间起始元素小于上一轮末尾元素，continue
            if (intervals[i][0] < end) {
                continue;
            }
            // 此处更新末尾元素与不用删除的区间数
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }
}
