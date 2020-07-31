public class Test125 {
    public boolean isPalindrome(String s) {
        //除去特殊符号，并转小写
        StringBuffer sNew = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sNew.append(Character.toLowerCase(ch));
            }
        }
        //使用双指针求证
        int left =0 ;
        int right = sNew.length()-1;
        while (left < right){
            if (sNew.charAt(left) != sNew.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
