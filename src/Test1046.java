import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1046 {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int len = stones.length - 1;
        for (int i = len; i > 0; i--) {
            stones[len] = stones[len] - stones[len - 1];
            stones[len - 1] = 0;
            Arrays.sort(stones);
        }
        return stones[len];
    }
}
