public class Test151 {
    public String reverseWords(String s) {
        String[] strings = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for(int i = strings.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if(strings[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strings[i] + " "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }
}
