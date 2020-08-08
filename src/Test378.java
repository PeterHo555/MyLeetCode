import java.util.Arrays;

public class Test378 {
    public int kthSmallest(int[][] matrix, int k) {
        //二分查找法
        int m = matrix.length, n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m - 1][n - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            //计算数组中小于当前mid的元素个数
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n && matrix[i][j] <= mid; j++)
                    count++;
            //数组中小于mid的个数小于k，调整下界，令low等于mid+1
            //反之，调整上界，令high等于mid-1
            if (count < k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        //经计算的下界元素，即数组中第k小的元素
        return low;





//        //直接排序法
//        int rows = matrix.length, columns = matrix[0].length;
//        int[] sorted = new int[rows * columns];
//        int index = 0;
//        for (int[] row : matrix) {
//            for (int num : row) {
//                sorted[index++] = num;
//            }
//        }
//        Arrays.sort(sorted);
//        return sorted[k - 1];
    }
}
