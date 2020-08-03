import java.util.Stack;

public class Test1047 {
    public String removeDuplicates(String S) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (stack.empty() || S.charAt(i) != stack.peek()) {
                stack.push(S.charAt(i));
            }else {
                stack.pop();
            }
        }
        while (!stack.empty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
