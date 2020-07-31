public class Test860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5){
                five++;
            }
            else if(bills[i] == 10){
                ten++;
                if (five < 1)
                    return false;
                five--;
            }else {
                if (ten > 0 && five > 0){
                    ten--;
                    five--;
                }
                else if (five > 3){
                    five -= 3;
                }else
                    return false;
            }
        }
        return true;
    }
}
