import java.util.List;

public class Test524 {
    public String findLongestWord(String s, List<String> d) {
        //初始化最长子串为空
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            //l1大于l2则不比较
            //或长度相同情况下字典顺序更大，注意：字典顺序是按照字母ASCII顺序大小比较
            //String元素，compareTo：
            //如果参数字符串等于此字符串，则返回值 0；
            //如果此字符串小于字符串参数，则返回一个小于 0 的值；
            //如果此字符串大于字符串参数，则返回一个大于 0 的值。
            if (l1 > l2|| (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    //双指针判断是否是子串
    private boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
