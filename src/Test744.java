public class Test744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int l = 0, r = len - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if (letters[mid] <= target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return letters[l % len];
    }
}
