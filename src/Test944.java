public class Test944 {
    public int minDeletionSize(String[] A) {
        //题目反人类，实际上就是保留矩阵中非降序排列的列，其余列删除，删除的列数就是输出。
        int ans = 0;
        for (int c = 0; c < A[0].length(); ++c)
            for (int r = 0; r < A.length - 1; ++r)
                if (A[r].charAt(c) > A[r+1].charAt(c)) {
                    ans++;
                    break;
                }
        return ans;
    }
}
