package com.samples.excel.leetcode;

public class ExcelLeetCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLeetCode(56554));

	}

	private static String findLeetCode(int n) {
		String s = "";
		while (n > 0) {
			n--;
			char l = ((char) (n % 26 + 'A'));
			s = String.valueOf(l) + s;
			n /= 26;
		}
		return s;
	}

}
