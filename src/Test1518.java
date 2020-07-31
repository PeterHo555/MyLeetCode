public class Test1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        int exchange;
        ans = ans + numBottles;
        while (numBottles/numExchange != 0){
            exchange = numBottles/numExchange;
            numBottles = numBottles % numExchange + exchange;
            ans += exchange;
        }
        return ans;
    }
}
