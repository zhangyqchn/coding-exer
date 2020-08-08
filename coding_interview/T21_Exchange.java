package algorithm;

public class T21_Exchange {
    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            while(i < j && ((nums[i] & 1) == 1)){
                i ++;
            }
            while(i < j && ((nums[j] & 1) == 0)){
                j --;
            }
            swap(nums, i, j);
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j){
        if(i == j) return;
        nums[i] += nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}
