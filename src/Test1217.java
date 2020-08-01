public class Test1217 {
    public int minCostToMoveChips(int[] chips) {
        //移动两个位置无代价，移动一个位置代价为1，实际上是奇偶问题
        //将全部筹码移到奇数位置的代价小还是移到偶数位置的代价小
        int even =0, odd = 0;
        for (int i = 0; i < chips.length; i++) {
            if (chips[i] % 2 ==1)
                odd++;
            else
                even++;
        }
        return Math.min(odd, even);
    }
}
