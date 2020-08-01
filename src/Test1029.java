import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1029 {
    public int twoCitySchedCost(int[][] costs) {
        //先假设全部去A市，再从中挑出最便宜的N个去B市，再减去差值。
        int ans = 0;
        for (int i = 0; i < costs.length; i++) {
            ans += costs[i][0];
        }
        int [] d_value = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            d_value[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(d_value);
        for (int i = 0; i < d_value.length/2; i++) {
            ans += d_value[i];
        }
        return ans;
    }
}
