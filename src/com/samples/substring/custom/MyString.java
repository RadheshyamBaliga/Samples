package com.samples.substring.custom;

/**
 * Sample Custom String implementation
 * @author amdin
 *
 */
public class MyString {
	
	private String str;
	
	public MyString(String s) {
		this.str = s;
	}
	
	public MyString subString(int begin) {
		String s = "";
		for (int i=begin; i<str.length(); i++) {
			s = s + str.charAt(i);
		}
		return new MyString(s);
	}
	
	//Important!!
	public String toString() {
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyString s1 = new MyString("string");     
        MyString substring = s1.subString(3);

        System.out.println(substring);
	}

}
