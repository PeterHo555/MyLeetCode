import java.util.Arrays;

public class Test242 {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return String.valueOf(sChars).equals(String.valueOf(tChars));
    }
}
