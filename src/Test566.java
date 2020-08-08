public class Test566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int index = 0;
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                //nums数组中第index个元素为nums[index / n][index % n]
                ans[i][j] = nums[index / n][index % n];
                index++;
            }
        }
        return ans;
    }
}
