package com.samples.combinations;

public class PrintDiffCombination {
	public static void main(String[] args) {

		// Create an alphabet to work with
		String s = "hat";
		char[] alphabet = s.toCharArray();
		// Find all possible combinations of this alphabet in the string size of
		// 3
		StringExcersise.possibleStrings(alphabet.length, alphabet, "");
	}

}

class StringExcersise {

	public static void possibleStrings(int maxLength, char[] alphabet,
			String curr) {

		// If the current string has reached it's maximum length
		if (curr.length() == maxLength) {
			System.out.println(curr);

			// Else add each letter from the alphabet to new strings and process
			// these new strings again
		} else {
			for (int i = 0; i < alphabet.length; i++) {
				String oldCurr = curr;
				curr += alphabet[i];
				possibleStrings(maxLength, alphabet, curr);
				curr = oldCurr;
			}
		}
	}
}
