package graph;

import java.util.*;

public class WordLadder {
	
public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0)
            return 0;
        
        return helper(beginWord, endWord, wordList);
    }
    
    private int helper(String beginWord, String endWord, Set<String> wordList) {
        
        int steps = 0;
        LinkedList<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        queue.add(beginWord);
        visited.add(beginWord);
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            steps++;
            for (int s = 0; s < size; s ++) {
                String curString = queue.removeFirst();
                for (int i = 0; i < curString.length(); i ++) {
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        String newStr = replaceChar(curString, i, c);
                        
                        if (newStr.equals(endWord))
                            return ++steps;
                            
                        if (!visited.contains(newStr) && wordList.contains(newStr)) {
                            queue.add(newStr);
                            visited.add(curString);
                        }
                    }
                }
            }
        }
        return 0;
    }
    
    private String replaceChar(String curString, int index, char c) {
        char[] chars = curString.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
	
	public static void main(String[] args) {

	}

}
