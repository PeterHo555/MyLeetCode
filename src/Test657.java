public class Test657 {
    public boolean judgeCircle(String moves) {
        int m = 0, n = 0;
        //迭代器效率更高
        for (char ch : moves.toCharArray()) {
            if (ch == 'U')
                m++;
            else if (ch == 'D')
                m--;
            else if (ch == 'L')
                n++;
            else if (ch == 'R')
                n--;
        }
        return m == 0 && n == 0;
    }
}
