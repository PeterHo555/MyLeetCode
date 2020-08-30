import java.util.ArrayList;
import java.util.List;

public class Test241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // 识别到运算符，分别递归计算运算符两侧的运算结果
            // 分治的思想
            if (c == '+' || c == '-' || c == '*') {
                // 获得所有的可行左运算结果
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                // 获得所有的可行右运算结果
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                // 从左结果集合和右结果集合选出一个进行运算
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }

            }
        }
        //分治到最后 way长度为0，此时才能存入答案，return到上一层计算
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }
}
