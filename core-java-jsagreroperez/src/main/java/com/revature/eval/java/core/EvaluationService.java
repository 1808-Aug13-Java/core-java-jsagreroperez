package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	
	public String reverse(String string) {
		// TODO Write an implementation for this method declaration
		char [] arr = new char [string.length()];
		int j = string.length() -1; //minus 1 because it is out of bounds of the string index
		for (int i =0; i< string.length(); i++)
		{
			arr[i] = string.charAt(j);
			j--;
		}
		return (new String(arr));
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		Scanner input = new Scanner(phrase);
		String acr = new String();
		while(input.hasNext())
		{
			String nop = input.next();
			int count = 0;
			acr = acr + nop.charAt(0);
			for(char pip: nop.toCharArray()) {
				if((pip == '-')||(pip == '_')) {
					System.out.println(nop.charAt(count+1));
					acr = acr + nop.charAt(count+1);
				}
				count+=1;
			}
		}
		acr = acr.toUpperCase();
		System.out.println(phrase);
		System.out.println(acr);
		return acr;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			boolean check = ((this.getSideOne() == this.getSideTwo()) && (this.getSideOne() == this.getSideThree())) ? true : false;
			return check;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			boolean check = ((this.getSideOne() == this.getSideTwo()) || (this.getSideOne() == this.getSideThree())) ? true : false;
			return check;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			boolean check = ((this.getSideOne() != this.getSideTwo()) && (this.getSideOne() != this.getSideThree()) && (this.getSideThree() != this.getSideTwo())) ? true : false;
			return check;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		int score = 0;
		for ( char ch: string.toCharArray()) {
			switch(ch) {
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
			case 'L':
			case 'N':
			case 'R':
			case 'S':
			case 'T':
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'l':
			case 'n':
			case 'r':
			case 's':
			case 't':{
				score+=1;
				break;
			}
			case 'D':
			case 'G':
			case 'd':
			case 'g':{
				score+=2;
				break;
			}
			case 'B':
			case 'C':
			case 'M':
			case 'P':
			case 'b':
			case 'c':
			case 'm':
			case 'p': {
				score+=3;
				break;
			}
			case 'F':
			case 'H':
			case 'V':
			case 'W':
			case 'Y':
			case 'f':
			case 'h':
			case 'v':
			case 'w':
			case 'y':{
				score+=4;
				break;
			}
			case 'K':
			case 'k':{
				score+=5;
				break;
			}
			case 'J':
			case 'X': 
			case 'j':
			case 'x':{
				score+=8;
				break;
			}
			case 'Q':
			case 'Z': 
			case 'q':
			case 'z':{
				score+=10;
				break;
			}
			}
		}
		System.out.println("the scrabble score: " +score);
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		String num = new String();
		for(char ch: string.toCharArray()) {
			if(Character.isDigit(ch))
			{
				num = num + ch;
			}
			//if((ch != '-') && (ch != '(') && (ch != ')') && (ch != '+'))
		}
		if((num.length() == 10) && (num.indexOf(0) != 1) && (num.indexOf(3) != 1)) {
			System.out.println("a valid number!!!: " +num);
			return num;
		}
		if((num.length()==11) && (num.indexOf(0) != 1) && (num.indexOf(1) != 1) && (num.indexOf(4) != 1)) {
			num = num.substring(1, num.length());
			System.out.println("a valid number: " + num);

			return num;
		}
		throw new IllegalArgumentException();

	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		Map<String,Integer> map = new HashMap<String,Integer>();
		int hold;
		String[] token = string.split(" ");
		String[] tokenCramped = string.split(",");
		System.out.println(tokenCramped.length);
		String[] tokenUsed;
		if(tokenCramped.length > token.length)
			tokenUsed = tokenCramped;
		else
			tokenUsed = token;
			
		for(String a: tokenUsed) {
			if(map.isEmpty()) {
				
				map.put(a, new Integer(1));
				System.out.println(map);

			}
			else if(!(map.containsKey(a))) {
				
				map.put(a, new Integer(1));
				System.out.println(map);

			}
			else if(map.containsKey(a)){
				
				hold = map.get(a);
				hold += 1;
				map.put(a, hold);
				
			}
		}
		System.out.println(map);
		return map;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			
			if(this.sortedList.contains(t)) {
				return (this.sortedList.indexOf(t));
			}
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * a , e , i , o , u
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * consonant:   B, C, D, F, G, H, J, K, L, M, N, P, Q, R, S, T, V, X, Z, and usually W and Y
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		System.out.println(string);
		String[] token = string.split(" ");
		String returning = new String("");
		for(String a: token) {
			int count = 0;
			boolean check = false;
			for(char b: a.toCharArray()) {
				if(((b == 'a')||(b == 'e')||(b == 'i')||(b == 'o')||(b == 'u')||(b == 'A')||(b == 'E')||(b == 'I')||(b == 'O')||(b == 'U'))&&(count > 1)) {
					returning = returning + " " + (a.substring(count) + a.substring(0, (count )) + "ay" );
					check = true;
					break;
				}
				else if(((b == 'a')||(b == 'e')||(b == 'i')||(b == 'o')||(b == 'u')||(b == 'A')||(b == 'E')||(b == 'I')||(b == 'O')||(b == 'U'))&&(count == 1)) {
					returning = returning + " " + (a.substring(count) + a.charAt(0) + "ay" );
					check = true;
					break;
				}
				else if(((b == 'a')||(b == 'e')||(b == 'i')||(b == 'o')||(b == 'u')||(b == 'A')||(b == 'E')||(b == 'I')||(b == 'O')||(b == 'U'))&&(count == 0)) {
					returning = returning + " " + (a + "ay" );
					check = true;
					break;
				}
				count+=1;
			}
			if(check == false)
				returning = returning + " " + a;
		}
		if(returning.charAt(0) == ' ') {
			returning = returning.substring(1);
		}
		System.out.println(returning);
		return returning;
		// TODO Write an implementation for this method declaration
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		String arm = Integer.toString(input);
		int exp = arm.length();
		int holder = 0;
		for(char a: arm.toCharArray()) {
			int baby = Character.getNumericValue(a);
			holder = (int) (holder + Math.pow(baby, exp));
		}
		System.out.println(input + "is armstrong? =" + ((holder == input) ? true:false));
		return ((holder == input) ? true:false);
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		System.out.println("long= " + l);
		// TODO Write an implementation for this method declaration
		List<Long> factors = new ArrayList<Long>();
		long copy = l;
		for(long i = 2; i<=copy; i++) {
			if((copy%i) == 0) {
				factors.add(i);
				copy /= i;
				i--;
			}
		}
		System.out.println(factors);
		return factors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			String rot = "";
			int holder = 0;
			for(char a: string.toCharArray()) {
			holder = (int) a;
			if((holder > 66) && (holder < 91)) {
				if((holder+this.key) > 90) {
					int tempKey = key;
					while((holder+tempKey) > 90) {
						tempKey = (holder+tempKey - 90);
						holder = 64;
					}
					holder = holder + tempKey;
					rot = rot + (Character.toString(((char)holder)));
					continue;
					
				}
				holder = holder + this.key;
				rot = rot + (Character.toString(((char)holder)));
			}
			else if(((holder > 96) && (holder < 123))) {
				if((holder+this.key) > 122) {
					int tempKey = this.key;
					while((holder+tempKey) > 122) {
						tempKey = (holder+tempKey - 122); 
						holder = 96;


					}
					holder = holder + tempKey;
					rot = rot + (Character.toString(((char)holder)));
					continue;
					
				}
				holder = holder + this.key;
				rot = rot + (Character.toString(((char)holder)));
				
			}
			else
				rot = rot + ((Character.toString(((char)holder))));

		}
		return rot;
		}
		}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration");
		
		if( i < 1) {
			throw new IllegalArgumentException();
		}
		if(i == 1) {
			return 2;
		}
		int count = 1;
		int focus = 2;
		boolean check = false;
		do
		{
			focus +=1;
			for(int p = 2; p < (focus); p++ ) {
				if(focus%p == 0) {
					check = true;
					break;
				}
			}//for loop checks if current focus is a prime number
			if(check == false) {//if it is a prime number icrement count
				count+=1;
			}
			check = false;			
		}while(count !=i);
		return focus;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		/* This implementation included the spacing and punctuation, but the tests excluded it, so im saving this just in case
		public static String encode(String string)  {
			// TODO Write an implementation for this method declaration
			System.out.println("befor rot: " + string); 
			String rot = "";
			int holder = 0;
			for(char a: string.toCharArray()) {
			holder = (int) a;
			if((holder > 66) && (holder < 91)) {
				if(holder < 77) {
					holder = (25 -(2*(holder-65))) + holder;
					System.out.println("holder = " + holder);
					rot = rot + ((Character.toString(((char)holder))));

				}
				else {
					holder = holder - (25 -(2*(90-holder)));
					rot = rot + ((Character.toString(((char)holder))));

				}
				
			}
			else if(((holder > 96) && (holder < 123))) {
				if(holder < 109) {
					holder = (25 -(2*(holder-97))) + holder;
					rot = rot + ((Character.toString(((char)holder))));

				}
				else {
					holder = holder - (25 -(2*(122-holder)));
					rot = rot + ((Character.toString(((char)holder))));

				}
			}	
			else
				rot = rot + ((Character.toString(((char)holder))));

		}
		System.out.println("rot is = "+rot);
		return rot;
		}
		*/
		
		public static String encode(String string)  {
			// TODO Write an implementation for this method declaration
			System.out.println("befor rot: " + string); 
			String rot = "";
			int holder = 0;
			int count = 0;
			for(char a: string.toCharArray()) {
				if(count == 5) {
					rot = rot + " ";
					count = 0;
				}
				if(Character.isDigit(a)) {
					rot = rot + a;
					count +=1;
				}
				holder = (int) a;
				if((holder > 64) && (holder < 91)) {
					if(holder < 77) {
						holder = (25 -(2*(holder-65))) + holder;
						System.out.println("holder = " + holder);
						rot = rot + ((Character.toString(((char)holder))));
						count+=1;
						}
					else {
						holder = holder - (25 -(2*(90-holder)));
						rot = rot + ((Character.toString(((char)holder))));
						count+=1;


					}
				
				}
				else if(((holder > 96) && (holder < 123))) {
					if(holder < 109) {
						holder = (25 -(2*(holder-97))) + holder;
						rot = rot + ((Character.toString(((char)holder))));
						count+=1;


					}
					else {
						holder = holder - (25 -(2*(122-holder)));
						rot = rot + ((Character.toString(((char)holder))));
						count+=1;


					}
					
				}	

			}
			rot = rot.toLowerCase();
			if(rot.charAt(rot.length() -1) == ' ') {
				rot = rot.substring(0, rot.length() -1);			
				}
			System.out.println("rot is = "+rot);
			return rot;
			}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			System.out.println("befor pip: " + string); 
			String pip = "";
			int holder = 0;
			for(char a: string.toCharArray()) {
			holder = (int) a;
			if(Character.isDigit(a)) {
				pip = pip + a;
				continue;
			}
			if((holder > 66) && (holder < 91)) {
				if(holder < 77) {
					holder = (25 -(2*(holder-65))) + holder;
					System.out.println("holder = " + holder);
					pip = pip + ((Character.toString(((char)holder))));

				}
				else {
					holder = holder - (25 -(2*(90-holder)));
					pip = pip + ((Character.toString(((char)holder))));

				}
				
			}
			else if(((holder > 96) && (holder < 123))) {
				if(holder < 109) {
					holder = (25 -(2*(holder-97))) + holder;
					pip = pip + ((Character.toString(((char)holder))));

				}
				else {
					holder = holder - (25 -(2*(122-holder)));
					pip = pip + ((Character.toString(((char)holder))));

				}
			}	

		}
		System.out.println("pip is = "+pip);
		return pip;
		}
}
	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		String pup = "";
		boolean check = false;
		for(char a: string.toCharArray()) {
			if(Character.isDigit(a)) {
				pup = pup + a;
			}
			else if((a == 'X') || (a == 'x')) {
				pup = pup+a;
			}
			
		}
		System.out.println(pup);
		System.out.println(pup.indexOf(Character.toString('X')));
		System.out.println(pup.length()-2);

		if(pup.length() != 10) {
			check = false;
		}
		//else if X is located between two numbers
		else if((pup.indexOf(Character.toString('X')) > 0) && (pup.indexOf(Character.toString('X')) < ((pup.length())- 2))) {
			System.out.println("heck");
			check =false;
		}
		//else if x is located between two numbers
		else if((pup.indexOf(Character.toString('x')) > 0) && (pup.indexOf(Character.toString('x')) < (pup.length())- 2)) {
			check = false;
		}
		else {
			int sum = 0;
			int countDown = 10;
			for(char a : pup.toCharArray()) {
				if(Character.isDigit(a)) {
					sum = sum + (Character.getNumericValue(a)) *countDown;
					countDown-=1;
				}
				else {
					sum = sum + 10*countDown;
					countDown-=1;
				}
				
			}
			if((sum % 11) == 0) {
				System.out.println(sum);
				check = true;;
			}
			else
				check = false;
			System.out.println(sum);

		}
		System.out.println(string + " is " + check);
		return check;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		String pup = "";
		if(string.replace(" ", "").equals("")) {
			return false;
		}
		int [] arr = new int[26];
		for(char a: string.toCharArray()) {
			switch (a) {
			
			case 'a':
			case 'A':{
				arr[0] =1;
				break;
				
			}
				
			case 'b':
			case 'B':{
				arr[1] =1;
				break;

			}

			case 'c':
			case 'C':{
				arr[2] =1;
				break;

			}
			case 'd':
			case 'D':{
				arr[3] =1;
				break;

			}
			case 'e':
			case 'E':{
				arr[4] =1;
				break;
				
			}
			case 'f':
			case 'F':{
				arr[5] =1;
				break;
				
			}
			case 'g':
			case 'G':{
				arr[6] =1;
				break;

			}
			case 'h':
			case 'H':{
				arr[7] =1;
				break;
				
			}
			case 'i':
			case 'I':{
				arr[8] =1;
				break;
				
			}
			case 'j':
			case 'J':{
				arr[9] =1;
				break;
				
			}
			case 'k':
			case 'K':{
				arr[10] =1;
				break;
				
			}
			case 'l':
			case 'L':{
				arr[11] =1;
				break;
				
			}
			case 'm':
			case 'M':{
				arr[12] =1;
				break;
				
			}
			case 'n':
			case 'N':{
				arr[13] =1;
				break;
				
			}
			case 'o':
			case 'O':{
				arr[14] =1;
				break;
				
			}
			case 'p':
			case 'P':{
				arr[15] =1;
				break;
				
			}
			case 'q':
			case 'Q':{
				arr[16] =1;
				break;
				
			}
			case 'r':
			case 'R':{
				arr[17] =1;
				break;
				
			}
			case 's':
			case 'S':{
				arr[18] =1;
				break;
				
			}
			case 't':
			case 'T':{
				arr[19] =1;
				break;
				
			}
			case 'u':
			case 'U':{
				arr[20] =1;
				break;
				
			}
			case 'v':
			case 'V':{
				arr[21] =1;
				break;
				
			}
			case 'w':
			case 'W':{
				arr[22] =1;
				break;
				
			}
			case 'x':
			case 'X':{
				arr[23] =1;
				break;
				
			}
			case 'y':
			case 'Y':{
				arr[24] =1;
				break;
				
			}
			case 'z':
			case 'Z':{
				arr[25] =1;
				break;
				
			}
			
			
			}
			
		}
		boolean check = true;
		for(int b: arr) {
			if(b != 1)
				check = false;
		}
		System.out.println(string+ "is " + check);
		return check;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		if(!(given.isSupported(ChronoField.HOUR_OF_DAY))) {// check if the given temporal supports time
			System.out.println("NOTSUPPORTED");
			LocalDate date = LocalDate.parse(given.toString());
			// convert to LOCALDATETIME by parsing and adding timme with atStartofDay
			LocalDateTime localDateTime1 = date.atStartOfDay();
			localDateTime1 = localDateTime1.plus(1_000_000_000, ChronoUnit.SECONDS);
			//add 1 gigasecond to the original date using ChronoUnit.SECONDS which gives the unit of time
			return localDateTime1;
			/*
			 * <R extends Temporal> R addTo(R temporal,
                             long amount)
Returns a copy of the specified temporal object with the specified period added.
The period added is a multiple of this unit. For example, this method could be used to add "3 days" to a date by calling this method on the instance representing "days", passing the date and the period "3". The period to be added may be negative, which is equivalent to subtraction.

There are two equivalent ways of using this method. The first is to invoke this method directly. The second is to use Temporal.plus(long, TemporalUnit):

   // these two lines are equivalent, but the second approach is recommended
   temporal = thisUnit.addTo(temporal);
   temporal = temporal.plus(thisUnit);
 
It is recommended to use the second approach, plus(TemporalUnit), as it is a lot clearer to read in code.
			 * 
			 */
		}
		else {
			LocalDateTime localDateTime2 = LocalDateTime.parse(given.toString());
			localDateTime2 = localDateTime2.plus(1_000_000_000, ChronoUnit.SECONDS);
			System.out.println(localDateTime2);
			return localDateTime2;
		}
		
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		ArrayList<Integer> stew = new ArrayList<Integer>();
		for(int goat: set) {
			int cheese = 1;
			while((goat*cheese) < i) {
				if( !(stew.contains(goat*cheese)) ) {
					stew.add(goat*cheese);
				}
				cheese +=1;
			}
		
		}
		int sum = 0;
		for(int a: stew) {
			sum = a+sum;
			
		}
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		string=string.replace(" ", "");
		if(string.length() < 2) {
			return false;
		}
		String holder = "";
		for(char a: string.toCharArray()) {
			if(Character.isDigit(a)) {
				holder = holder + a;
			}
			if(!(Character.isDigit(a))) {
				return false;
			}
		}
		int finalIndex = holder.length() -1; 
		int [] sum = new int[finalIndex + 1];
		int place = 0;
		System.out.println(holder);
		while((finalIndex - 1) > -1) {
			System.out.println("First "+Character.getNumericValue(holder.charAt(finalIndex)));
			sum[finalIndex] = Character.getNumericValue(holder.charAt(finalIndex));
			finalIndex -= 1;

			place = (Character.getNumericValue(holder.charAt(finalIndex))) * 2;
			if(place > 9)
			{
				place = place - 9;
			}
			System.out.println("Second "+Character.getNumericValue(holder.charAt(finalIndex)));
			
			sum[finalIndex] = place;
			finalIndex -= 1;
		}
		//System.out.println(sum);

		place = 0;
		for(int luhn: sum) {
			place = luhn + place;
		}
		System.out.println(place);
		System.out.println((place%10) == 0);
		return ((place%10) == 0)?true:false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		ArrayList<String> hill = new ArrayList<String>();
		String [] tokens = string.split(" ");
		for(String bobby: tokens) {
			if((Character.isDigit(bobby.charAt(0)) )|| ((bobby.charAt(0) == '-'))) {
				String holder = "";
				for(char pip : bobby.toCharArray()) {
					if(Character.isDigit(pip) || (pip =='-')) {
						holder = holder + pip;
					}
				}
				hill.add(holder);
			}
			
			if((bobby.equals("plus") )||(bobby.equals("minus") )||(bobby.equals("multiplied") )||(bobby.equals("divided") )) {
				hill.add(bobby);
				continue;
			}
		}
		System.out.println(hill.get(0));
		System.out.println(hill.get(1));
		System.out.println(hill.get(2));
		switch(hill.get(1)) {
		
		case"plus": {
			System.out.println(Integer.parseInt(hill.get(0))+ Integer.parseInt(hill.get(2)));

			return (Integer.parseInt(hill.get(0))+ Integer.parseInt(hill.get(2)));
		}
		case"minus": {
			System.out.println(Integer.parseInt(hill.get(0))- Integer.parseInt(hill.get(2)));

			return (Integer.parseInt(hill.get(0))- Integer.parseInt(hill.get(2)));

		}
		case"multiplied": {
			System.out.println(Integer.parseInt(hill.get(0))* Integer.parseInt(hill.get(2)));

			return (Integer.parseInt(hill.get(0))* Integer.parseInt(hill.get(2)));

		}
		case"divided": {
			System.out.println(Integer.parseInt(hill.get(0))/ Integer.parseInt(hill.get(2)));
			return (Integer.parseInt(hill.get(0))/ Integer.parseInt(hill.get(2)));

		}
		
		
		
		}
		System.out.println("0");
		return 0;
	}

}
