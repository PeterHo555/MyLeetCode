import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1002 {
    public List<String> commonChars(String[] A) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        for (String word: A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a']; // 通过ascii码转成字符对应的数字
            }
            // 留下最小的字符数量
            for (int i = 0; i < 26; ++i) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }
        // 本质上求交集
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minFreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
