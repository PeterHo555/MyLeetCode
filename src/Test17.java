import java.util.ArrayList;
import java.util.List;

public class Test17 {
    private String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        //判断临界情况
        if (digits == null || digits.length() == 0)
            return ans;
        doCombination(new StringBuilder(), ans, digits);
        return ans;
    }

    private void doCombination(StringBuilder prefix, List<String> ans, String digits){
        if (prefix.length() == digits.length()) {
            ans.add(prefix.toString());
            return;
        }
        //利用ascii码，将当前位转成数字
        int curDigits = digits.charAt(prefix.length()) - '0';
        //取出数字代表的字符
        String letters = keys[curDigits];
        for (char c : letters.toCharArray()) {
            prefix.append(c);
            doCombination(prefix, ans, digits);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
