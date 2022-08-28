package javaWordle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LetterCheck {

	public LetterCheck() {
		
	}
	
//	this class handles the situation if guess is correct
	public static boolean ifCorrect(String word, String guess) {
		
		boolean correct = false;
	
		if (word.toUpperCase().equals(guess.toUpperCase())) {
			
			
			correct = true;
			
		} else {
			correct = false;
		}
		return correct;
	}
	
//	this class handles the situations in which the correct string isn't guessed
	public static void ifIncorrect(String word, String guess) {
//		both the guess and the word in question are split into character arrays
		String[] guessCharArray = guess.toUpperCase().split("");
		String[] wordCharArray = word.toUpperCase().split("");
		
		
		
		
		
//		All words are five letters in length so the loop runs for the length of the word
		for (int i = 0; i < 5; i++) {
			
//			prints feedback if character at certain position is correct
			if (wordCharArray[i].equals(guessCharArray[i])) {
				
				System.out.println(guessCharArray[i] + " at position " + (i + 1) + " is correct");
			}
			
			Stream<String> wordList = Arrays.stream(wordCharArray);
//			prints feedback if the guessed character is in the word but no the correct position
			if ((wordCharArray[i].equals(guessCharArray[i]) == false) && (wordList.anyMatch(guessCharArray[i]::equals))) {
				System.out.println("Letter: " + guessCharArray[i] + " is in the word, but not at position " + (i + 1));
			} 
			
//			prints feedback if the character is not part of the word at all
			Stream<String> wordList2 = Arrays.stream(wordCharArray);
			if ((wordCharArray[i].equals(guessCharArray[i]) == false) && (!wordList2.anyMatch(guessCharArray[i]::equals))) {
				System.out.println(guessCharArray[i] + " at position " + (i + 1) + " is not a letter in the word");
			}
				
			
			
			
			
			
		}
		
		
		
		
		
		
	}

}
