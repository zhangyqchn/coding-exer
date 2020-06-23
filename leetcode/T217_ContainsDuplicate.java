package easy.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T217_ContainsDuplicate {
	public boolean containsDuplicate0(int[] nums) {
		int n = nums.length;
		if(n<2) return false;
		Set<Integer> s = new HashSet<Integer>();
		for(int i: nums) {
			if(!s.add(i)) return true;
		}
		return false;
    }
	public boolean containsDuplicate1(int[] nums) {
		int n = nums.length;
		if(n<2) return false;
		Arrays.sort(nums);
		for(int i=0; i<n-1; i++) {
			if(nums[i] == nums[i+1]) return true;
		}
		return false;
	}
	public boolean containsDuplicate2(int[] nums) {
		int n = nums.length;
		if(n<2) return false;
		int max = nums[0], min = nums[0];
		for(int i=0; i<n; i++) {
			if(nums[i] > max) {
				max = nums[i];
				continue;
			}
			if(nums[i] < min) {
				min = nums[i];
				continue;
			}
			for(int j=0; j<i; j++) {
				if(nums[i] == nums[j]) return true;
			}
		}
		return false;
	}
}
