public class Test459 {
    public boolean repeatedSubstringPattern(String s) {
        //返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，
        //如果此字符串中没有这样的字符，则返回 -1。
        //如s = "abab"，s+s = "abababab"，1之后的abab的fromIndex为2
        return (s + s).indexOf(s, 1) != s.length();
    }
}
