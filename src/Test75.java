public class Test75 {
    public void sortColors(int[] nums) {
        //0，1，2 排序。一次遍历，如果是0，则移动到表头，如果是2，则移动到表尾，不用考虑1。
        int low = 0, now = 0, high = nums.length - 1;
        while (now <= high) {
            if (nums[now] == 0) {
                swap(nums, low, now);
                low++;
                now++;
            } else if (nums[now] == 2) {
                swap(nums, high, now);
                high--;
            } else {
                now++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
