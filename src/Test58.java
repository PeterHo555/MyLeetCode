public class Test58 {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        //寻找最后一个单词的结束位
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        //寻找最后一个单词的开始位
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
//        int ans = 0;
//        int flag = 1;//代表第一次遇到空格
//        int end = s.length()-1;
//        while (end >= 0){
//            if (s.charAt(end) == ' ' && flag == 1) {
//                flag = 0;
//            }
//
//            ans++;
//            end--;
//
//        }
//        return ans;

    }
}
