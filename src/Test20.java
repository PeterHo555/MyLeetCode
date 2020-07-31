import java.util.Stack;

public class Test20 {
    public boolean isValid(String s) {
        if (s.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            //当字符分别为({[，向栈中存入)}],如果字符串括号字符匹配，则栈顶字符会与其一致
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }
        return stack.empty();
    }
}
