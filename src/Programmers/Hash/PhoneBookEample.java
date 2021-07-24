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
		int i;
		int j;
		for (i = 0; i < phoneBook.length; i++) {
			for (j = i+1; j < phoneBook.length; j++) {
				if (phoneBook[j].startsWith(phoneBook[i]))
					return false;
				if (phoneBook[i].startsWith(phoneBook[j]))
					return false;
			}
		}

		return true;
	}
	
	
	
}
