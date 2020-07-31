public class Test292 {
    //如果堆中石头的数量 nn 不能被 44 整除，那么你总是可以赢得 Nim 游戏的胜利。
    public boolean canWinNim(int n) {
        return (n%4 != 0);
    }
}
