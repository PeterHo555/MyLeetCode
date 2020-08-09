public class Test667 {
    public int[] constructArray(int n, int k) {
        //题目描述：数组元素为 1\~n 的整数，要求构建数组，使得相邻元素的差值不相同的个数为 k。
        //让前 k+1 个元素构建出 k 个不相同的差值，序列为：1、k+1、 2、k、 3、k-1 ... k/2、k/2+1.
        int[] ret = new int[n];
        ret[0] = 1;
        for (int i = 1, interval = k; i <= k; i++, interval--) {
            ret[i] = i % 2 == 1 ? ret[i - 1] + interval : ret[i - 1] - interval;
        }
        for (int i = k + 1; i < n; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }
}
