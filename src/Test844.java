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
}
