import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int [] ans = new int [k];
        int max = 0;
        int add_key = 0;
        while(k > 0){
            for(int key : map.keySet()){
                if(map.get(key) > max){
                    max = map.get(key);
                    add_key = key;
                }
            }
            k--;
            ans[k] = add_key;
            map.remove(add_key);
            max = 0;
        }
        return ans;
    }
}
