public class Test67 {
    public static String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        //长的放在前面
        if (n < m)
            return addBinary(b, a);
        int L = Math.max(n, m);
        StringBuilder sb = new StringBuilder();
        int carry = 0, j = m - 1;
        //计算过程
        for(int i = L - 1; i >= 0; --i) {
            if (a.charAt(i) == '1')
                ++carry;
            if (j > -1 && b.charAt(j--) == '1')
                ++carry;
            if (carry % 2 == 1)
                sb.append('1');
            else
                sb.append('0');
            carry /= 2;
        }
        //若最后多出一位carry，加入字符串
        if (carry == 1)
            sb.append('1');
        //反转字符串得到答案
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(Math.pow(10, 2));
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        sb.append("0");
        System.out.println(sb.toString());
        System.out.println(addBinary("1111","11"));

    }
}
