package advancedAlgorithms;

public class palindrome {
	
	public static String findLongestPalindrome2(String str) {
		int str_length = str.length();
		boolean[][] table = new boolean[str_length][str_length];
		int max_length = 0;
		int max_i = 0;
		int max_j = 0;
		//Construct the table
		
		//Prefill length 1 & 2
		
		for (int i = 0; i < str.length(); i ++) {
			table[i][i] = true;
			if (max_length == 0) {
				max_length = 1;
				max_i = i;
				max_j = i;
			}
		}
		
		for (int i = 0; i < str.length() -1; i ++) {
			if (str.charAt(i) == str.charAt(i+1)) {
				table[i][i+1] = true;
				if (2 > max_length) {
					max_length = 2;
					max_i = i;
					max_j = i + 1;
				}
			}
				
			else 
				table[i][i+1] = false;
		}

		for (int interval = 3; interval - 1 < str.length(); interval ++) {
			for (int i = 0; i + interval - 1 < str.length(); i ++) {
				
				int j = i + interval - 1;
				if (table[i+1][j-1] && str.charAt(i) == str.charAt(j)) {
					table[i][j] = true;
					max_length += 2;
					max_i = i;
					max_j = j;
				}
				else 
					table[i][j] = false;
			}
		}
		return max_length > 0 ? str.substring(max_i, max_j + 1) : "";
		
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
		
		System.out.println(palindrome.findLongestPalindrome2("ccc"));
	}

}
