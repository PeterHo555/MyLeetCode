import java.util.Stack;

public class Test844 {
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return false;
        String s1 = handler(S);
        String s2 = handler(T);
        if(s1.equals(s2)) return true;
        return false;
    }

    public String handler(String str) {
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (int  i = str.length() - 1; i >= 0; i--) {
            if(str.charAt(i) == '#') {
                count++;
            } else {
                if(count!= 0) count--;
                else sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
//    public boolean backspaceCompare(String S, String T) {
//        Stack<Character> stack1 = new Stack<>();
//        Stack<Character> stack2 = new Stack<>();
//        for(int i = 0; i < S.length(); i++){
//            if(!stack1.isEmpty() && S.charAt(i) == '#'){
//                stack1.pop();
//            }else if(S.charAt(i) != '#'){
//                stack1.push(S.charAt(i));
//            }
//        }
//        for(int j = 0; j < T.length(); j++){
//            if(!stack2.isEmpty() && T.charAt(j) == '#'){
//                stack2.pop();
//            }else if(T.charAt(j) != '#'){
//                stack2.push(T.charAt(j));
//            }
//        }
//        if(stack1.size() != stack2.size() ) return false;
//        while(!stack1.isEmpty()){
//            if(stack1.pop() != stack2.pop()) return false;
//        }
//        return true;
//    }
}
