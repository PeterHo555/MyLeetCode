public class Test201 {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
            System.out.println(m+"::::"+n);
        }
        //回退shift步
        return m << shift;
    }
}
