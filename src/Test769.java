public class Test769 {
    public int maxChunksToSorted(int[] arr) {
        //思路
        //首先找到从左块开始最小块的大小。
        //如果前 k 个元素为 [0, 1, ..., k-1]，可以直接把他们分为一个块。
        //当我们需要检查 [0, 1, ..., n-1] 中前 k+1 个元素是不是 [0, 1, ..., k] 的时候，只需要检查其中最大的数是不是 k 就可以了。
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }
        return ans;
    }
}
