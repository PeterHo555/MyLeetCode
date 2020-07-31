import java.util.Arrays;
import java.util.Collections;

public class Test1300 {
    public static int findBestValue(int[] arr, int target) {
        //初始化最小差
        int min =Integer.MAX_VALUE;
        int num = target/arr.length;
        //最小差索引
        int minIndex = 0;
        for (int i = num; i < target; i++) {
            //若数据元素大于i，累加i，小于i，累加其元素，得到sum
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j]>i){
                    sum += i;
                }else {
                    sum += arr[j];
                }
            }
            //更新最小差与其索引
            if (Math.abs(target-sum) < min) {
                min = Math.abs(target-sum);
                minIndex = i;
            }else
                break;
        }
        return minIndex;
    }
    public static void main(String[] args) {
        int[] arr = {1547,83230,57084,93444,70879};
        int target = 71237;
        int ans = findBestValue(arr,target);

        System.out.println(ans);

    }

}
