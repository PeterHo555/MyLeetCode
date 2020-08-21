public class Test476 {
    //对于 00000101，要求补码可以将它与 00000111 进行异或操作。那么问题就转换为求掩码 00000111
    public int findComplement(int num) {
        if (num == 0) return 1;
        int mask = 1 << 30;
        while ((num & mask) == 0) mask >>= 1;
        mask = (mask << 1) - 1;
        return num ^ mask;
    }

    //可以利用 Java 的 Integer.highestOneBit() 方法来获得含有首 1 的数。
//    public int findComplement(int num) {
//        if (num == 0) return 1;
//        int mask = Integer.highestOneBit(num);
//        mask = (mask << 1) - 1;
//        return num ^ mask;
//    }
}
