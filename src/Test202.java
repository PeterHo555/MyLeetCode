import java.util.HashSet;
import java.util.Set;

public class Test202 {
    public boolean isHappy(int n) {
        //暴力就完事了
        if (n <= 0)
            return false;
        int now = 0;
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1){
            while (n != 0){
                now += Math.pow(n % 10, 2);
                n /= 10;
            }
            //出现重复值就终止
            if (set.contains(now)){
                return false;
            }
            set.add(now);
            n = now;
            now = 0;
        }
        return true;
    }
}
