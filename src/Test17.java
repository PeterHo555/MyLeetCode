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
        //当前字符穿长度等于数字组合长度
        //表示当前是一种组合的答案，存入答案后回溯
        if (prefix.length() == digits.length()) {
            ans.add(prefix.toString());
            return;
        }
        //利用ascii码，将当前位转成数字
        int curDigits = digits.charAt(prefix.length()) - '0';
        //取出数字代表的字符
        String letters = keys[curDigits];
        for (char c : letters.toCharArray()) {
            prefix.append(c); //添加
            doCombination(prefix, ans, digits);
            //回溯去掉最后一位，接着起始前进一位
            prefix.deleteCharAt(prefix.length() - 1); //删除
        }
        //注意，遍历完当前letters后回溯到上一层的letters
        //如，String为"234"，再遍历完"4"的首轮"ghi"后，自动回溯到"3"的"def"
        //此时，"d"删去，存入"e"，然后接着遍历"4"的"ghi"
    }
}
