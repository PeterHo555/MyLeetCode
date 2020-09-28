public class Test123 {
    public int maxProfit(int[] prices) {
        // 最多只能两次交易
        //对于任意一天考虑四个变量:
        //fstBuy: 在该天第一次买入股票可获得的最大收益
        //fstSell: 在该天第一次卖出股票可获得的最大收益
        //secBuy: 在该天第二次买入股票可获得的最大收益
        //secSell: 在该天第二次卖出股票可获得的最大收益
        // 分别对四个变量进行相应的更新, 最后secSell就是最大
        // 收益值(secSell >= fstSell)
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        System.out.println("curPrice："+"\t"+"firstBuy"+"\t"+"firstSell"+"\t"+"secondBuy"+"\t"+"secondSell");
        for (int curPrice : prices) {
            if (firstBuy < -curPrice) {
                firstBuy = -curPrice;
            }
            if (firstSell < firstBuy + curPrice) {
                firstSell = firstBuy + curPrice;
            }
            if (secondBuy < firstSell - curPrice) {
                secondBuy = firstSell - curPrice;
            }
            if (secondSell < secondBuy + curPrice) {
                secondSell = secondBuy + curPrice;
            }

            System.out.println("curPrice："+curPrice+"\t"+firstBuy+"\t"+firstSell+"\t"+secondBuy+"\t"+secondSell);
        }
        return secondSell;
    }
}
