import java.util.HashMap;

public class Test13 {
    public int romanToInt(String s) {
        int ans = 0;
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("I", 1);
        hashMap.put("IV", 4);
        hashMap.put("V", 5);
        hashMap.put("IX", 9);
        hashMap.put("X", 10);
        hashMap.put("XL", 40);
        hashMap.put("L", 50);
        hashMap.put("XC", 90);
        hashMap.put("C", 100);
        hashMap.put("CD", 400);
        hashMap.put("D", 500);
        hashMap.put("CM", 900);
        hashMap.put("M", 1000);
        for(int i = 0;i < s.length();) {
            //先判断两位有无匹配，再判断一位
            if(i + 1 < s.length() && hashMap.containsKey(s.substring(i, i+2))) {
                ans += hashMap.get(s.substring(i, i+2));
                i += 2;
            } else {
                ans += hashMap.get(s.substring(i, i+1));
                i ++;
            }
        }
        return ans;
    }
}
