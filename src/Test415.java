public class Test415 {
    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        int carry = 0, len1 = num1.length() - 1, len2 = num2.length() - 1;
        while (len1 >= 0 && len2 >= 0){
            carry = (int)num1.charAt(len1) + (int)num2.charAt(len2) +carry;
            ans.append(carry%10);
            carry = carry/10;
            len1--;
            len2--;
        }
        while (len1 >= 0){
            ans.append((num1.charAt(len1) + carry)%10);
            carry = (num1.charAt(len1) + carry)/10;
            len1--;
        }
        while (len2 >= 0){
            ans.append((num2.charAt(len2) + carry)%10);
            carry = (num2.charAt(len2) + carry)/10;
            len2--;
        }
        return ans.reverse().toString();


//        StringBuilder sb = new StringBuilder();
//        int carry = 0, i = num1.length()-1, j = num2.length()-1;
//        while(i >= 0 || j >= 0 || carry != 0){
//            if(i>=0) carry += num1.charAt(i--)-'0';
//            if(j>=0) carry += num2.charAt(j--)-'0';
//            sb.append(carry%10);
//            carry /= 10;
//        }
//        return sb.reverse().toString();
    }
}
