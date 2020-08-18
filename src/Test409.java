import java.util.HashMap;
import java.util.Map;

public class Test409 {
    public int longestPalindrome(String s) {
        int[] cnts = new int[256];
        for (char c : s.toCharArray()) {
            cnts[c]++;
        }
        int palindrome = 0;
        for (int cnt : cnts) {
            palindrome += (cnt / 2) * 2;
        }
        if (palindrome < s.length()) {
            palindrome++;   // 这个条件下 s 中一定有单个未使用的字符存在，可以把这个字符放到回文的最中间
        }
        return palindrome;
    }
    //超时
//    public int longestPalindrome(String s) {
//        int ans = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                int count = map.get(s.charAt(i)) + 1;
//                map.put(s.charAt(i), count);
//            }else {
//                map.put(s.charAt(i), 1);
//            }
//        }
//        int flag = 0;
//        for (Character temp : map.keySet()) {
//            if (map.get(temp) % 2 == 0 ) {
//                ans += map.get(temp);
//            }else {
//                flag = 1;
//            }
//        }
//        return ans+flag;
//    }
}
