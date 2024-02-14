package com.nt.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Pair {
    String first;
    int second;
    Pair(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

public class Hd_49_WordLadder1 {

	//T(C)= O(N2 * M)  and S(C)=O(N * M)
	public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
		  Set<String> s = new HashSet<>();
	        int len = wordList.length;
	        for(int i = 0; i < len; i++) {
	            s.add(wordList[i]);
	        }
	        
	        Queue<Pair> q = new LinkedList<>();
	        s.remove(startWord);
	        q.offer(new Pair(startWord, 1));
	        
	        while (!q.isEmpty()) {
	            String word = q.peek().first;
	            int steps = q.peek().second;
	            q.poll();
	            
	            if (word.equals(targetWord)) return steps;
	            
	            for (int i = 0; i < word.length(); i++) {
	                for (char ch = 'a'; ch <= 'z'; ch++) {
	                    char[] r = word.toCharArray();
	                    r[i] = ch;
	                    String rp_word = new String(r);
	                    if (s.contains(rp_word)) {
	                        s.remove(rp_word);
	                        q.offer(new Pair(rp_word, steps + 1));
	                    }
	                }
	            }
	        }
	        return 0;
	}

	public static void main(String[] args) {
		String wordList[] = { "poon", "plee", "same", "poie", "plea", "plie", "poin" };
		String startWord = "toon", targetWord = "plea";
		int response = wordLadderLength(startWord, targetWord, wordList);
		System.out.println("The Expected output is ::" + response);

	}

}
