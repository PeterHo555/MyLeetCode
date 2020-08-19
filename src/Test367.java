public class Test367 {
    public boolean isPerfectSquare(int num) {
        //牛顿迭代法
        long r = num;
        while (r * r > num) {
            r = (r + num/r) /2;
        }
        return r * r == num;
    }
}
