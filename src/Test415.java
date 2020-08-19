public class Test415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        //从末位开始相加，当两个字符串数下标>=0时，或者进位不为0时，
        //计算当前位相加结果存入StringBuilder
        while(i >= 0 || j >= 0 || carry != 0){
            if(i >= 0)
                carry += num1.charAt(i--) - '0';
            if(j >= 0)
                carry += num2.charAt(j--) - '0';
            sb.append(carry%10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}
