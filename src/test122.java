public class test122 {
    public int maxProfit(int[] prices) {
        //把问题看作每天都对股票买卖，有利益就在总数上累加
        int sum = 0;
        int temp = 0;
        for (int i = 1; i < prices.length; i++) {
            temp = prices[i]-prices[i-1];
            if(temp > 0)
                sum += temp;
        }
        return sum;
    }
}
