package Programmers.Hash;

import java.util.Arrays;

public class PhoneBookEample {

	public static void main(String[] args) {
		String[] phone_book1 = {"119", "97674223", "1195524421"};
		String[] phone_book2 = {"123","456","789"};
		String[] phone_book3 = {"12","123","1235","567","88"};
		
		mySolution(phone_book1);
	}
	
	public static boolean mySolution(String[] phoneBook) {
		boolean answer = true;
		
		for(int i=0; i<phoneBook.length-1; i++) {
			for(int j=i+1;j<phoneBook.length;j++) {
				System.out.println("phoneBook[i] : " + phoneBook[i]);
				System.out.println("phoneBook[j] : " + phoneBook[j]);
				System.out.println("phoneBook startsWith : " + phoneBook[j].startsWith(phoneBook[i]));
				if(phoneBook[j].startsWith(phoneBook[i])) {
					return false;
				}
				if(phoneBook[i].startsWith(phoneBook[j])) {
					return false;
				}

			}
		}
		
		System.out.println("---------------------------");
		System.out.println("answer : " + answer);
		System.out.println("---------------------------");
		return answer;
	}
	
	
	
}
