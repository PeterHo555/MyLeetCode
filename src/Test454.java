import java.util.HashMap;
import java.util.Map;

public class Test454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // 遍历 A 和 B 所有元素和的组合情况，并记录在 ab_map 中，ab_map 的 key 为两数和，value 为该两数和出现的次数
        // 遍历 C 和 D 所有元素和的组合情况，取和的负值判断其是否在 ab_map 中，若存在则取出 ab_map 对应的 value 值，count = count + value
        Map<Integer, Integer> countAB = new HashMap<>();
        for(int a : A){
            for(int b : B){
                countAB.put(a + b, countAB.getOrDefault(a + b, 0) + 1);
            }
        }
        int ans = 0;
        for(int c : C){
            for(int d : D){
                if(countAB.containsKey(-c - d)){
                    ans += countAB.get(-c - d);
                }
            }
        }
        return ans;
    }
}
