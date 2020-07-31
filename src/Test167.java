public class Test167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int flag = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i]+numbers[j] == target && i!=j) {
                    ans[0]=numbers[i];
                    ans[1]=numbers[j];
                    flag = 1;
                    break;
                }
            }
            if (flag==1){
                break;
            }
        }
        return ans;
    }
}
