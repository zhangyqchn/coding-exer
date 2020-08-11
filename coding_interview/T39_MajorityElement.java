package algorithm;

public class T39_MajorityElement {
    public int majorityElement(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0];
        int x = nums[0];
        int votes = 1;
        for(int i = 1; i < n; i ++){
            if(votes == 0) x = nums[i];
            if(nums[i] == x) votes ++;
            else votes --;
        }
        return x;
    }
}
