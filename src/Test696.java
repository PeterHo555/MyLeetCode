public class Test696 {
    public int countBinarySubstrings(String s) {
        int  n = s.length();
        int pre = 0;
        int curr = 1;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                curr++;
            }
            else {
                pre = curr;
                curr = 1;
            }
            if (pre >= curr) ans++;
        }
        return ans;
    }
}
