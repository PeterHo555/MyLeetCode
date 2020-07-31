import java.util.ArrayList;
import java.util.List;

public class Test345 {
    public String reverseVowels(String s) {
        char[] letters = s.toCharArray();
        //使用双指针
        List<Character> letterList = new ArrayList<>();
        char[] letter=new char[] {'a','e','i','o','u','A','E','I','O','U'};
        int len = s.length();
        int left = 0, right = len-1;
        if (len == 1)
            return s;
        for(int i = 0 ; i < 10 ; i++)
            letterList.add(letter[i]);
        char temp;
        System.out.println(left+":::::"+right);
        while (left < right){
            if (letterList.contains(letters[left]) && letterList.contains(letters[right])) {
                System.out.println("in");
                temp = letters[left];
                letters[left] = letters[right];
                letters[right] = temp;
                left++;
                right--;
            }
            else if (!letterList.contains(letters[left]) && letterList.contains(letters[right])) {
                left++;
            }
            else if (letterList.contains(letters[left]) && !letterList.contains(letters[right])) {
                right--;
            }
            else {
                left++;
                right--;
            }
        }
        s = String.valueOf(letters);
        return s;
    }
}
