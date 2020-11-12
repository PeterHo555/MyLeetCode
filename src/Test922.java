public class Test922 {
    public int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];
        int odd = 1;
        int even = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                result[even] = A[i];
                even += 2; //偶数下标移动
            } else {
                result[odd] = A[i];
                odd += 2; //奇数下标移动
            }
        }
        return result;
    }
}
