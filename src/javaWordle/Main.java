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
		
		
//		Gets the random word which the user is trying to guess
		WordList list = new WordList();
		String randomStr = list.getRandomWord();
		
		System.out.println(randomStr);
		
//		creates the query url to fetch the api data
		String queryStr = String.format("https://api.dictionaryapi.dev/api/v2/entries/en/%s", randomStr);
		
//		returns json from the url call
		JSONArray json = Api.readJsonFromUrl(queryStr);
		
//		gets the particular json datafield we want to return in the console
		String definition = json.getJSONObject(0).getJSONArray("meanings").getJSONObject(0).getJSONArray("definitions").getJSONObject(0).getString("definition");
		
		
//		creating a scanner to allow users to input data
		Scanner newStr = new Scanner(System.in);
		
//		Intro strings
		System.out.println("Welcome to Wordle");
		System.out.println("Please guess a 5 letter word");
		System.out.println("You will be told if you have a character in the correct position");
		System.out.println("You have six attemps at finding the word");

//		this loop prints particular strings to the console depending upon whether the character is correct, incorrect or correct but wrong position			
		for (int i = 0; i < 6; i++) {
			String attempt1 = newStr.nextLine();
			if (attempt1.length() != 5) {
				System.out.println("Please input a word that is 5 letters long");	
			}
			if (LetterCheck.ifCorrect(randomStr, attempt1) == true) {
				System.out.println(randomStr + " is the correct word, Congratulations");
				
//				if the guess is correct it will print the definition to the console
				System.out.println(String.format("Definition: %s", definition));
		
				
				return;
			}
			
			LetterCheck.ifIncorrect(randomStr, attempt1);
		}
//		if the word is not found after six attempts the following strings will be printed
		System.out.println("Too many attempts, YOU LOSE!");
		System.out.println(String.format("The word was: %s", randomStr));		
		
	}

}
