import java.util.ArrayList;
import java.util.List;

public class Test1441 {
    public List<String> buildArray(int[] target, int n) {
        int len = target.length;
        int i, j=0;
        List<String> result = new ArrayList<>();
        for (i=0; i<len; i++){
            for (j=j+1; j<=n; j++){
                if (target[i] == j){
                    result.add("Push");
                    break;
                }else if(j<target[i]){
                    result.add("Push");
                    result.add("Pop");
                    continue;
                }
            }
        }
        return result;
    }
}
