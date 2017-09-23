package com.samples.code.reverse;

public class StringReverseRecursion {
	
	public static void main(String[] args) {
		String s = "radheshyam";
		System.out.println(reverse(s));
	}
	
	private static String reverse(String s) {
		// base case
		if (s.length() <= 1) {
			return s;
		}
		// take substring from 1st element to the end and append finally with first char
		return reverse(s.substring(1, s.length())) + s.charAt(0);
	}

}
