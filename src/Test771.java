import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test771 {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : J.toCharArray()) {
            set.add(c);
        }
        for (Character c : S.toCharArray()) {
            if (set.contains(c)){
                map.put(c, map.getOrDefault(c,0) + 1);
            }
        }
        for (Character c : map.keySet()) {
            ans += map.get(c);
        }
        return ans;
    }
}
