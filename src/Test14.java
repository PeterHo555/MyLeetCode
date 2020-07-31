public class Test14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            //对比暂时的ans的和新字符串的最大公共前缀，从0开始
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                //出现不同字母时，跳出此次循环
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            //替换最新ans
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
}
