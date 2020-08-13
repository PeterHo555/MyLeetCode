public class Test43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        //开辟新数组，存入每一位的计算结果
        int[] res = new int[len1 + len2];
        /*
        * 例子：
        * num1:123、num2:45
        *            45
        *           123
        *        -------
        *           135
        *           900
        *          4500
        *        --------
        *          5535
        * */
        for (int i = len1 - 1; i >= 0; i--) {
            //取出num1当前计算位，如：3
            int n1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                //取出num2当前计算位，，如：5，4
                int n2 = num2.charAt(j) - '0';
                //计算当前相乘结果，如上列子第一次计算为，如：0+3*5 = 15，1+3*4=13
                int sum = (res[i + j + 1] + n1 * n2);
                //求余存入当前位，如：5，3
                res[i + j + 1] = sum % 10;
                //存入进位，如：1，1
                res[i + j] += sum / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }
}
