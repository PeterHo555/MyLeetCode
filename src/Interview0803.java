public class Interview0803 {
    public int findMagicIndex(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == i)
//                return i;
//        }
//        return -1;
        //跳跃法
        for(int i=0;i<nums.length; ){
            if(nums[i]==i)
                return i;
            i=Math.max(nums[i],i+1);
        }
        return -1;
    }
}
