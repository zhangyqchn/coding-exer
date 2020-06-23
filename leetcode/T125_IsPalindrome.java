/*
 * 验证回文串
 * valid-palindrome
 */

package problems;

public class T125_IsPalindrome {
	public boolean isPalindrome0(String s) {
		s = s.toLowerCase();
		int n = s.length();
		char temp;
		for(int i = 0; i < n; i++) {
			temp = s.charAt(i);
			if(!((temp >= 'a' && temp <= 'z' ) || (temp >= '0' && temp <= '9'))) {
				System.out.println(s.charAt(i));
				s = s.replace(s.charAt(i), ' ');
			}
		}
		s = s.replace(" ", "");
		n = s.length();
        if(n < 1) {
        	return true;
        }
        for(int i = 0; i < n/2; i++) {
        	if(s.charAt(i) != s.charAt(n-1-i)) {
        		return false;
        	}
        }
		return true;
    }
	
	public boolean isPalindrome1(String s) {
//		s = s.toLowerCase();
		int n = s.length();
		if(n < 1) return true;
		int left = 0, right = n - 1;
		while(left < right) {
			while((!Character.isLetterOrDigit(s.charAt(left))) && left < right) {
				left++;
			}
			while((!Character.isLetterOrDigit(s.charAt(right))) && left < right) {
				right--;
			}
			if(left < right) {
				if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))	return false;
				left++;
				right--;
			}
		}
		return true;
	}
	
	public boolean isPalindrome3(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }
}
