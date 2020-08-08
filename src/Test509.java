public class Test509 {
    public int fib(int N) {
        //递归斐波那契
        if (N == 0)
            return 0;
        else if (N == 1 || N == 2)
            return 1;
        return fib(N-1)+fib(N-2);
    }
}
