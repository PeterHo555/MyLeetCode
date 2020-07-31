public class Test557 {
    public String reverseWords(String s) {
        //定义双指针和临时变量对每个单词求解
//        int left= 0;
//        int right = 0;
//        char[] tempArr = s.toCharArray();
//        char temp;
//        for (int i = 0; i < tempArr.length; i++) {
//            if (tempArr[i] == ' ') {
//                right = i-1;
//                while (left <right){
//                    temp = tempArr[left];
//                    tempArr[left] = tempArr[right];
//                    tempArr[right] = temp;
//                    left++;
//                    right--;
//                }
//                left = i+1;
//            }
//        }
//        return tempArr.toString();

        //将每个单词分割成单词数组，对每个单词reverse，存入新的string
        String words[] = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }
}
