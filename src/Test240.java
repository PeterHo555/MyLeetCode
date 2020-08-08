public class Test240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n-1;
        //col--比col++更合适处理此情况
        while (row < m && col >= 0){
            if (target == matrix[row][col]) return true;
            else if (target < matrix[row][col]) col--;
            else
                row++;
        }
        return false;
    }
}
