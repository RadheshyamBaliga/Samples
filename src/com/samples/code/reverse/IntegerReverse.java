package com.samples.code.reverse;

public class IntegerReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 45540;//leading zeroes result in octal
		reverse(i);
	}
	
	public static void reverse(int i) {
		int t = 0;
		int rem = 0;	
		StringBuilder sb = new StringBuilder();
		while((rem = i%10) != 0 || i > 0) {
			
			t = t *10 + rem;
			sb.append(rem);
			i = i/10;
		}
		System.out.println(sb.toString());
		
	}
	
	

}
