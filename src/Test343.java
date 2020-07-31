public class Test343 {
    public int integerBreak(int n) {
        //通过数学方法可证明，几何平均不等式，求导
//        最优： 33 。把数字 nn 可能拆为多个因子 33 ，余数可能为 0,1,20,1,2 三种情况。
//        次优： 22 。若余数为 22 ；则保留，不再拆为 1+11+1 。
//        最差： 11 。若余数为 11 ；则应把一份 3 + 13+1 替换为 2 + 22+2，因为 2 \times 2 > 3 \times 12×2>3×1。
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }
}
