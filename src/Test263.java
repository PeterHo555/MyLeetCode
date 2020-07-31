public class Test263 {
    public boolean isUgly(int num) {
        //对能被2,3,5整除的数不断除2,3,5，最后剩1就是，剩0就不是，除2可以用位运算替换
        if (num<1) return false;
        while (num%5==0){
            num/=5;
        }
        while (num%3==0){
            num/=3;
        }
        num =num % 2;
        return num == 1;
    }
}
