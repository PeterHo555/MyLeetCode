import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test451 {
    public String frequencySort(String s) {
        // 统计所有字符出现的频率
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
        // 获取字符的频率
        for (char c : map.keySet()) {
            int f = map.get(c);
            // 当前频率的list为空，则new一个list
            if (frequencyBucket[f] == null) {
                frequencyBucket[f] = new ArrayList<>();
            }
            // 将所有出现频率一样的字符，add到同一个list
            frequencyBucket[f].add(c);
        }
        StringBuilder str = new StringBuilder();
        for (int i = frequencyBucket.length - 1; i >= 0; i--) {
            // 字符不存在则continue
            if (frequencyBucket[i] == null) {
                continue;
            }
            // 构成String
            for (char c : frequencyBucket[i]) {
                for (int j = 0; j < i; j++) {
                    str.append(c);
                }
            }
        }
        return str.toString();
    }
}
