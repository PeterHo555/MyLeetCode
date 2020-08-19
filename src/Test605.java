public class Test605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0, len = flowerbed.length, pre, next;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1)
                continue;
            //判断此时的前一位与后一位是否越界
            //判断此时的前一位与后一位是否种花
            pre = i == 0 ? 0 : flowerbed[i - 1];
            next = i == len - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0){
                //将此处种花，并计数
                count++;
                flowerbed[i] = 1;
            }
        }
        return count >= n;
    }
}
