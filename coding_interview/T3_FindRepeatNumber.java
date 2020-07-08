package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T3_FindRepeatNumber {
    public int findRepeatNumber0(int[] nums){   //暴力 o(n^2）
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums){   //先排序再查重 o(n)
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-1;i++){
            if(nums[i] == nums[i+1])
                return nums[i];
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums){   //hash表 o(n)
        Set<Integer> s = new HashSet<>();
        for(int i:nums){
//            if(!s.add(i)) return i;
            if(s.contains(i)) return i;
            else s.add(i);
        }
        return -1;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findRepeatNumber3(int[] nums){   //利用数组下标
        int n = nums.length;
        for(int i = 0; i < n; i ++){
            if(i != nums[i] && nums[i] != nums[nums[i]]){
                swap(nums, i, nums[i]);
            }
            if(i != nums[i] && nums[i] == nums[nums[i]]) {
                return nums[i];
            }
        }
        return -1;
    }
}
