public class Test941 {
    // 下饭代码
//    public boolean validMountainArray(int[] A) {
//        if(A == null || A.length <= 2) return false;
//        if(A[0] >= A[1]) return false;
//        boolean up = true;
//        for(int i = 1; i < A.length; i++){
//            if(up){
//                if(A[i-1] < A[i]) continue;
//                else if(A[i-1] == A[i]) return false;
//                else up = false;
//            } else{
//                if(A[i-1] > A[i]) continue;
//                else return false;
//            }
//        }
//        if(up) return false;
//        return true;
//    }

    // 双指针
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int left = 0, right = A.length - 1;
        while (left < A.length - 2 && A[left] < A[left + 1]) left++;
        while (right > 1 && A[right] < A[right - 1]) right--;
        return left == right;
    }
}
