public class Test696 {
    public int countBinarySubstrings(String s) {
        int  n = s.length();
        int pre = 0;
        int curr = 1;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            //记录当前相同字符个数
            if (s.charAt(i) == s.charAt(i+1)) {
                curr++;
            } else {
                pre = curr;
                curr = 1;
            }
            //当前相同字符个数与前一相同字符个数比较，若小于，则累加答案个数
            if (pre >= curr)
                ans++;
        }
        return ans;
    }
}
