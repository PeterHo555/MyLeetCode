import java.util.Arrays;

public class Test214 {
    // 官方题解KMP
    public String shortestPalindrome(String s) {
        int n = s.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int best = -1;
        for (int i = n - 1; i >= 0; --i) {
            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                best = fail[best];
            }
            if (s.charAt(best + 1) == s.charAt(i)) {
                ++best;
            }
        }
        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();
    }


//    // 前插法再判断是否是回文，超时
//    public String shortestPalindrome(String s) {
//        StringBuilder sb = new StringBuilder();
//        sb.insert(0, s);
//        int high = s.length() - 1, last = s.length() - 1;
//        for (int i = 0; i < s.length(); i++) {
//            if (isPlalindrome(sb.toString(), i, last)) {
//                return sb.toString();
//            }
//            sb.insert(i, s.charAt(high));
//            high--;
//        }
//        return sb.toString();
//    }
//
//    private boolean isPlalindrome(String s, int low, int high){
//        while (low < high){
//            if (s.charAt(low) != s.charAt(high)) {
//                return false;
//            }
//            low++;
//            high--;
//        }
//        return true;
//    }
}
