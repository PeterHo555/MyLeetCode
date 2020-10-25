public class Test845 {
    // 先找到比左右两侧大的数 然后以这个数为中心 依次找到左右的长度
    public int longestMountain(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1])
                max = Math.max(prolong(A, i), max);
        }
        return max;
    }

    private int prolong(int[] A, int cur){
        int l = cur - 1;
        int r = cur + 1;
        while (l > 0 && A[l - 1] < A[l]) {
            l--;
        }
        while (r < A.length - 1 && A[r + 1] < A[r]) {
            r++;
        }
        return r - l + 1;
    }
}
