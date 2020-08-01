import java.util.Arrays;

public class Test1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int ans = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0 && K > 0){
                A[i] = -A[i];
                K--;
            }
            ans += A[i];
            min = Math.min(min, A[i]);
        }
        if (K > 0 && K % 2 == 1)
            ans = ans - 2 * min;
        return ans;
    }
}
