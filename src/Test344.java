public class Test344 {
    public void reverseString(char[] s) {
        //定义双指针和临时变量求解
        int left = 0;
        int right = s.length - 1;
        char temp;
        while (left <right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
