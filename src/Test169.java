import java.util.HashMap;

public class Test169 {
    public int majorityElement(int[] nums) {
        //利用哈希表求解
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int count = 0;
        int len = nums.length;
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],1);
            }else {
                count = hashMap.get(nums[i]);
                hashMap.put(nums[i],count+1);
            }
            System.out.println(hashMap.get(nums[i]));
            if (hashMap.get(nums[i]) > len/2)
                ans = nums[i];
        }
        return ans;
    }
}
