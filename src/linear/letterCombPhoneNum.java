package linear;

import java.util.*;

public class letterCombPhoneNum {

	//To do: why cannot create char arrayList in java
	public static List<String> letterCombinations(String digits) {
        HashMap<Character, String[]> phoneBook = contructPhoneBook();
        List<String> result = new ArrayList<String>();
        for (char digit : digits.toCharArray()) {
            List<String> letterArray = Arrays.asList(phoneBook.get(digit));
            if (result.size() == 0) {
            	//letterArray.forEach(x -> result.add("a" + x)); //To do: need to figure out why not working
            	for (String letter: letterArray) {
            		result.add(letter);
            	}
            }
            else {
                List<String> newResultList = new ArrayList<String>();
                for (String substring : result) {
                    letterArray.forEach(x -> newResultList.add(substring + x));
                }
                result = newResultList;
            }
        }
        return result;
    }
    
    private static HashMap<Character, String[]> contructPhoneBook() {
        HashMap<Character, String[]> phoneBook = new HashMap<Character, String[]>();
        phoneBook.put('0', new String[] {});
        phoneBook.put('1', new String[] {});
        phoneBook.put('2', new String[] {"a", "b", "c"});
        phoneBook.put('3', new String[] {"d", "e", "f"});
        phoneBook.put('4', new String[] {"g", "h", "i"});
        phoneBook.put('5', new String[] {"j", "k", "l"});
        phoneBook.put('6', new String[] {"m", "n", "o"});
        phoneBook.put('7', new String[] {"p", "q", "r", "s"});
        phoneBook.put('8', new String[] {"t", "u", "v"});
        phoneBook.put('9', new String[] {"w", "x", "y", "z"});
        return phoneBook;
    }
    
    public static void main(String[] args) {
    	System.out.println(letterCombPhoneNum.letterCombinations("23"));
    }
}
