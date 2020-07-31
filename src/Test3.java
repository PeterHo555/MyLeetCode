import java.util.HashMap;

public class Test3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int ans = 0;
        for (int end = 0, start = 0; end < s.length(); end++) {
            //如果当前出现重复字母，窗口左指针右移到重复字母上次出现的右一位
            if (map.containsKey(s.charAt(end))) {
                System.out.println("map.get(s.charAt(end))::::"+map.get(s.charAt(end)));
                start = Math.max(map.get(s.charAt(end))+1, start);
            }
            //不断更新的窗口长度与原来所求结果的最大值
            ans = Math.max(ans, end - start + 1);
            //将出现字母与最新出现的位置存入HashMap
            map.put(s.charAt(end), end);
        }
        return ans;
    }
}
