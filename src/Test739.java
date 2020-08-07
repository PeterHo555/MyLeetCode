import java.util.Stack;

public class Test739 {
    public int[] dailyTemperatures(int[] T) {
//        int len = T.length;
//        int[] ans = new int[len];
//        for (int i = 0; i < len; i++) {
//            for (int j = i; j < len; j++) {
//                if (T[j] > T[i]) {
//                    ans[i] = j - i;
//                    break;
//                }
//            }
//        }
//        return ans;
        int n = T.length;
        int[] dist = new int[n];
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex < n; curIndex++) {
            //下标栈不为空，且当前温度大于上一次下标的温度
            //思路是先将出现的下标存入栈中，当下一个温度比此下标温度大的时候，计算出两个下标的差值
            while (!indexs.isEmpty() && T[curIndex] > T[indexs.peek()]) {
                int preIndex = indexs.pop();
                System.out.println("preIndex:"+preIndex);
                dist[preIndex] = curIndex - preIndex;
                System.out.println(dist[preIndex]);
            }
            indexs.add(curIndex);
        }
        return dist;
    }
}
