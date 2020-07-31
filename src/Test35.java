public class Test35 {
    public int searchInsert(int[] nums, int target) {
        //初始化二分法的左右指针
        int left = 0, right = nums.length - 1;
        //二分法的循环条件
        while(left <= right) {
            //计算中点位置，长度为奇数中点刚好为中，偶数中点为下半部分第一位
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
