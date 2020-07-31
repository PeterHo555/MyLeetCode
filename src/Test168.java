public class Test168 {
    public String convertToTitle(int n) {
        StringBuilder str = new StringBuilder();

        while (n != 0) {
            n--;
            str.insert(0, (char) (n % 26 + 65));
            n /= 26;
        }
        return str.toString();
    }
}
