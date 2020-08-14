public class Test34 {
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[2];
        if(nums.length == 0){
            result[0] = -1;
            result[1] = -1;
            return  result;
        }
        result[0] = findFirst(nums, nums.length, target);
        result[1] = findLast(nums, nums.length, target);
        return result;
    }

    public int findFirst(int [] a, int len, int key) {
        if (len < 1)
            return - 1;
        int low = 0;
        int high = len - 1;
        while(low <= high) {
            int mid = (low + high)/2;
            //寻找到目标值，且当mid-1越界或a[mid-1]不等于目标值
            if (a[mid] == key && (mid - 1 < 0 || a[mid - 1] != key)) {
                return mid;
            } else if (a[mid] >= key) {
                high = mid - 1;
            } else {//a[mid] < key 或 a[mid] == key && (mid - 1 >= 0 || a[mid - 1] == key))
                low = mid + 1;
            }
        }
        return -1;
    }

    public int findLast(int [] a, int len, int key) {
        if (len < 1)
            return - 1;
        int low = 0;
        int high = len - 1;
        while(low <= high){
            int mid = (low + high)/2;
            //寻找到目标值，且当mid+1越界或a[mid+1]不等于目标值
            if (a[mid] == key && (mid + 1 >= len || a[mid + 1] != key)) {
                return mid;
            } else if (a[mid] <= key) {
                low = mid + 1;
            } else {//a[mid] > key 或 a[mid] == key && (mid + 1 < len || a[mid + 1] == key)
                high = mid - 1;

            }
        }
        return -1;
    }
}
