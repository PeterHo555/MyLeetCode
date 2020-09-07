import java.util.Arrays;
import java.util.Comparator;

public class Test452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // 根据每行的末尾元素排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            // 若此区间起始元素小于等于上一轮末尾元素，continue
            if (points[i][0] <= end) {
                continue;
            }
            // 此处更新末尾元素
            // 累加需要的弓箭数
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }
}
