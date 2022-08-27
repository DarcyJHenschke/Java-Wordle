package javaWordle;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import org.json.JSONArray;
import org.json.JSONException;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws JSONException, IOException {
		
		
		
		WordList list = new WordList();
		String randomStr = list.getRandomWord();
		System.out.println(randomStr);
		String queryStr = String.format("https://api.dictionaryapi.dev/api/v2/entries/en/%s", randomStr);
		JSONArray json = Api.readJsonFromUrl(queryStr);
		String definition = json.getJSONObject(0).getJSONArray("meanings").getJSONObject(0).getJSONArray("definitions").getJSONObject(0).getString("definition");
		
		
		
		
		// create scanner
		// scan for a string
		// if inputed string is not 5 characters long throw an error
		// 
		Scanner newStr = new Scanner(System.in);
		System.out.println("Welcome to Wordle");
		System.out.println("Please guess a 5 letter word");
		System.out.println("You will be told if you have a character in the correct position");
		System.out.println("You have six attemps at finding the word");

		
		
		
		
		
		
		
		for (int i = 0; i < 6; i++) {
			String attempt1 = newStr.nextLine();
			if (attempt1.length() != 5) {
				System.out.println("Please input a word that is 5 letters long");	
			}
			if (LetterCheck.Y(randomStr, attempt1) == true) {
				System.out.println(randomStr + " is the correct word, Congratulations");
				System.out.println(String.format("Definition: %s", definition));
		
				
				return;
			}
			
			LetterCheck.X(randomStr, attempt1);
		}
		
		System.out.println("Too many attempts, YOU LOSE!");
		
		
		
		
//		
//		String attempt2 = newStr.nextLine();
//		if (attempt2.length() != 5) {
//			System.out.println("Please input a word that is 5 letters long");	
//		}
//		if (LetterCheck.Y(randomStr, attempt2) == true) {
//			System.out.println(randomStr + " is the correct word, Congratulations");
//			return;
//		}
//		LetterCheck.X(randomStr, attempt2);
//		
//		
//		
//		
//		String attempt3 = newStr.nextLine();
//		if (attempt3.length() != 5) {
//			System.out.println("Please input a word that is 5 letters long");
//		}
//		if (LetterCheck.Y(randomStr, attempt3) == true) {
//			System.out.println(randomStr + " is the correct word, Congratulations");
//			return;
//		}
//		LetterCheck.X(randomStr, attempt3);
//		
//		
//		String attempt4 = newStr.nextLine();
//		if (attempt4.length() != 5) {
//			System.out.println("Please input a word that is 5 letters long");
//		}
//		if (LetterCheck.Y(randomStr, attempt4) == true) {
//			System.out.println(randomStr + " is the correct word, Congratulations");
//			return;
//		}
//		LetterCheck.X(randomStr, attempt4);
//		
//		
//		
//		
//		String attempt5 = newStr.nextLine();
//		if (attempt5.length() != 5) {
//			System.out.println("Please input a word that is 5 letters long");			
//		}
//		if (LetterCheck.Y(randomStr, attempt5) == true) {
//			System.out.println(randomStr + " is the correct word, Congratulations");
//			return;
//		}
//		LetterCheck.X(randomStr, attempt5);
//		
//		
//		
//		
//		String attempt6 = newStr.nextLine();
//		if (attempt6.length() != 5) {
//			System.out.println("Please input a word that is 5 letters long");
//		}
//		if (LetterCheck.Y(randomStr, attempt6) == true) {
//			System.out.println(randomStr + " is the correct word, Congratulations");
//			return;
//			
//		}
//		LetterCheck.X(randomStr, attempt6);
//		
//		
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("Too many attempts, YOU LOSE!");
		
		

	}

}
