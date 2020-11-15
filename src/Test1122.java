import java.util.HashMap;

public class Test1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
//        int[] nums = new int[1001];
//        int[] res = new int[arr1.length];
//        //遍历arr1,统计每个元素的数量
//        for (int i : arr1) {
//            nums[i]++;
//        }
//        //遍历arr2,处理arr2中出现的元素
//        int index = 0;
//        for (int i : arr2) {
//            while (nums[i]>0){
//                res[index++] = i;
//                nums[i]--;
//            }
//        }
//        //遍历nums,处理剩下arr2中未出现的元素
//        for (int i = 0; i < nums.length; i++) {
//            while (nums[i]>0){
//                res[index++] = i;
//                nums[i]--;
//            }
//        }
//        return res;
        int[] ans = new int[arr1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        int k = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < map.get(arr2[i]); j++) {
                ans[k++] = arr2[i];
                map.put(arr2[i], map.get(arr2[i]) - 1);
            }
        }
        for (int num : map.keySet()) {
            while(map.get(num) > 0){
                ans[k++] = num;
                map.put(num, map.get(num) - 1);
            }
        }
        return ans;
    }
}
