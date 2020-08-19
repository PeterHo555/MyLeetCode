public class Test392 {
    public boolean isSubsequence(String s, String t) {
        int cur=0;
        //按顺序相等的字符数若等于s的长度，则为子序列
        for (int i = 0; i < t.length()&& cur<s.length(); i++) {
            if(t.charAt(i)==s.charAt(cur)) cur++;
        }
        return cur==s.length();
    }
}
