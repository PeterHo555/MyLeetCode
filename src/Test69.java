public class Test69 {
    public int mySqrt(int x) {
        //定义左右指针。
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            //定义中点
            int mid = l + (r - l) / 2;
            //若中点的平方大于x，令右指针为中点-1，反之暂令所求结果为中点
            if ((long)mid * mid <= x) {

                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
