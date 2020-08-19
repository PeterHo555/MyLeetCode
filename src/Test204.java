public class Test204 {
    public int countPrimes(int n) {
        //不是素数为true，默认为false
        boolean[] notPrimes = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrimes[i]) {
                continue;
            }
            count++;
            // 从 i * i 开始，因为如果 k < i，那么 k * i 在之前就已经被去除过了
            for (long j = (long) (i) * i; j < n; j += i) {
                notPrimes[(int) j] = true;
            }
        }
        return count;
    }

    //超时
//    public int countPrimes(int n) {
//        int ans = 0;
//        for (int i = 2; i < n; i++) {
//            if (isPrime(i)) {
//                ans++;
//            }
//        }
//        return ans;
//    }
//
//    private boolean isPrime(int n){
//        for(int i = 2; i <= Math.sqrt(n); ++i) {
//            if(n % i == 0) return false;
//        }
//        return true;
//    }
}
