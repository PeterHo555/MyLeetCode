public class Test461 {
    public int hammingDistance(int x, int y) {
        //位的异或运算，两数相等时，x^y = 0
        int z = x ^ y;
        int cnt = 0;
        while(z != 0) {
            //位与操作
            cnt += z & 1;
            z = z>>1;
        }
        return cnt;
    }
}
