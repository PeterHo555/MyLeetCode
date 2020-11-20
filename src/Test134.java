public class Test134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, need = 0, have = 0;
        int k = -1;
        for (int i = 0; i < gas.length; ++i) {
            int now = gas[i] - cost[i];
            // need: 到目前为止，需要的汽油量。
            need += now;
            // have： 到目前为止，拥有的最大汽油量.
            if (have < 0) {
                have = 0;
                k = -1;
            }
            if (k == -1) k = i;
            have += now;
        }
        return need >= 0 ? k : -1;
    }
}
