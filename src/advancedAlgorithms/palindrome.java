package advancedAlgorithms;

public class palindrome {
	
	public static String findLongestPalindrome2(String str) {
		
	}
	
	public static String findLongestPalindrome(String str) {
		
		int max_length = 0;
		String max_substring = "";
		if (str.length() > 0)
			max_length = 1;
		
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i ++) {
			for (int j = i+1; j < charArray.length; j++) {
				String curString = str.substring(i, j);
				if (isPalindrome(curString)) {
					if (j - i + 1 > max_length) {
						max_length = j - i + 1;
						max_substring = str.substring(i, j);
					}
				}
			}
		}
		return max_substring;
	}
	
	private static boolean isPalindrome(String str) {
		
		int p_start = 0;
		int p_end = str.length() - 1;
		
		while (p_start < p_end) {
			if (str.charAt(p_start) != str.charAt(p_end))
				return false;
			p_start ++;
			p_end --;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		System.out.println(palindrome.findLongestPalindrome("abbcbbabb"));
	}

}
