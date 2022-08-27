package javaWordle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LetterCheck {

	public LetterCheck() {
		
	}
	
	public static boolean Y(String word, String guess) {
		
		boolean correct = false;
	
		if (word.toUpperCase().equals(guess.toUpperCase())) {
			
			
			correct = true;
			
		} else {
			correct = false;
		}
		return correct;
	}
	
	
	public static void X(String word, String guess) {
		String[] guessCharArray = guess.toUpperCase().split("");
		String[] wordCharArray = word.toUpperCase().split("");
		
		
		
		
		
		
		for (int i = 0; i < 5; i++) {
			
			if (wordCharArray[i].equals(guessCharArray[i])) {
				
				System.out.println(guessCharArray[i] + " at position " + (i + 1) + " is correct");
			}
			
			Stream<String> wordList = Arrays.stream(wordCharArray);
				
			if ((wordCharArray[i].equals(guessCharArray[i]) == false) && (wordList.anyMatch(guessCharArray[i]::equals))) {
				System.out.println("Letter: " + guessCharArray[i] + " is in the word, but not at position " + (i + 1));
			} 
			
			Stream<String> wordList2 = Arrays.stream(wordCharArray);
			if ((wordCharArray[i].equals(guessCharArray[i]) == false) && (!wordList2.anyMatch(guessCharArray[i]::equals))) {
				System.out.println(guessCharArray[i] + " at position " + (i + 1) + " is not a letter in the word");
			}
				
			
			
			
			
			
		}
		
		
		
		
		
		
	}

}
