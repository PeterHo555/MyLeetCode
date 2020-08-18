public class Test647 {
    private int ans = 0;
    //从字符串的某一位开始，尝试着去扩展子字符串
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendSubstrings(s, i, i);     // 从当前字符开始奇数长度的回文数
            extendSubstrings(s, i, i + 1); // 从当前字符与当前下一字符开始偶数长度的回文数
        }
        return ans;
    }

    private void extendSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            ans++;
        }
    }
}
