import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Test1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int value : map.values()) {
            set.add(value);
        }
        return set.size() == map.size();
    }
}
