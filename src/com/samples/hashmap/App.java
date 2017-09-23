package com.samples.hashmap;

import java.util.HashMap;
import java.util.Map;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Key k1 = new Key("123", "456");
		Key k2 = new Key("123", "406");
		Key k3 = new Key("123", "457");
		Map<Key, String> hm = new HashMap<>();
		hm.put(k1, "junk1");
		hm.put(k2, "junk2");
		hm.put(k3, "junk3");
		
		System.out.println(hm.get(new Key("123", "456")));
		System.out.println(hm.get(k2));

	}
	
	public static class Key {
		
		String first;
		String last;
		
		public Key(String first, String last) {
			this.first = first;
			this.last = last;
		}
		
		public int hashCode() {
			return first.length() + last.length();
		}
		
		public boolean equals(Object o) {
			Key k = (Key)o;
			if (k.first.equals(this.first) && k.last.equals(this.last)) {
				return true;
			} else {
				return false;
			}
		}
	}

}
