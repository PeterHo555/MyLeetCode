public class Test925 {
    public boolean isLongPressedName(String name, String typed) {
        int len1 = name.length(), len2 = typed.length();
        int i = 0, j = 0;
        while (j < len2) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == len1;
    }
}
