import java.util.Arrays;

public class Test977 {
    public int[] sortedSquares(int[] A) {
        // 暴力api
//        for(int i = 0; i < A.length; i++) {
//            A[i] = A[i] * A[i];
//        }
//        Arrays.sort(A);
//        return A;

        // 双指针
        int len = A.length;
        int[] ans = new int[len];
        int l = 0, r = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (A[l] * A[l] > A[r] * A[r]) {
                ans[i] = A[l] * A[l];
                l++;
            } else {
                ans[i] = A[r] * A[r];
                r--;
            }
        }
        return ans;
    }
}
