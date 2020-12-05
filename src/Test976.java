import java.util.Arrays;

public class Test976 {
    public int largestPerimeter(int[] A) {
        /*
        为什么排序遍历相邻元素可行，有没有可能最优解为非相邻元素？（不会）
        证明：反证 假设 a , b, c 为最优解，且存在a',b',满足 a < a' < b < b' < c（存在非相邻元素）
        由于 a + b > c，a < a', 有 a' + b > c，(a', b, c)优于(a, b, c),与(a, b, c)为最优解矛盾，故不存在a'
        b'同理不存在 由于 a + b > c, b < b'，有a + b' > c，(a, b, c)为最优解矛盾，故不存在b'
        因此最优解一定为排序后相邻元素
        */
        Arrays.sort(A);
        for(int i = A.length - 1; i >= 2; i--) {
            int a = A[i];
            int b = A[i - 1];
            int c = A[i - 2];
            if(a < b + c){
                return a + b + c;
            }
        }
        return 0;

    }
}
