import java.util.Stack;

public class Test1021 {
    public String removeOuterParentheses(String S) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            //判断顺序不能变
            if (S.charAt(i) == ')')
                stack.pop();
            if (!stack.empty())
                ans.append(S.charAt(i));
            if (S.charAt(i) == '(')
                stack.push(S.charAt(i));
        }
        return ans.toString();
    }
}
