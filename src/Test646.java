import java.util.Arrays;
import java.util.Comparator;

public class Test646 {
    public int findLongestChain(int[][] pairs) {
        //根据第二项排列
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int res = 1, tmp = pairs[0][1];
        for(int i = 1;i < pairs.length;i++){
            if(pairs[i][0] > tmp){
                res++;
                tmp = pairs[i][1];
            }
        }
        return res;
    }
}
