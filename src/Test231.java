public class Test231 {
    public boolean isPowerOfTwo(int n) {
        //递归求解
        if(n==0) return false;
        if(n==1) return true;
        if(n%2!=0) return false;
        return isPowerOfTwo(n/2);
    }
}
