public class Test191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
//        int ans = 0;
//        while(n != 0) {
//            System.out.println(n);
//            if(n % 2 == 1){
//                ans++;
//            }
//            n /= 2;
//        }
//        return ans;

        int count = 0;
        while (n != 0) {
            //如果是0结尾，向前借1，就会导致‘与’运算之后相较于运算之前相比少一个1，如果是1同样也导致运算之后相较于运算之前少一个1。循环往复。
            count += n & 1;
            n = n >>> 1;
        }
        return count;

    }
}
