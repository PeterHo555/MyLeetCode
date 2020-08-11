public class Test167 {
//双指针
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
//暴力
//    public int[] twoSum(int[] numbers, int target) {
//        int[] ans = new int[2];
//        int flag = 0;
//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = 0; j < numbers.length; j++) {
//                if (numbers[i]+numbers[j] == target && i!=j) {
//                    ans[0]=numbers[i];
//                    ans[1]=numbers[j];
//                    flag = 1;
//                    break;
//                }
//            }
//            if (flag==1){
//                break;
//            }
//        }
//        return ans;
//    }
}
