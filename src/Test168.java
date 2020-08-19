public class Test168 {
    public String convertToTitle(int n) {
        StringBuilder str = new StringBuilder();
        //转字符前插法
        while (n != 0) {
            n--;
            str.insert(0, (char) (n % 26 + 65));
            n /= 26;
        }
        return str.toString();
    }
}
