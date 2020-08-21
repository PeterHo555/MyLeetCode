public class Test342 {
    public boolean isPowerOfFour(int num) {
        //这种数在二进制表示中有且只有一个奇数位为 1，例如 16（10000）
        return num > 0 && (num & (num - 1)) == 0 && (num & 0b01010101010101010101010101010101) != 0;
    }
}
