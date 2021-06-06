package Programmers.Hash;

public class PhoneBook {

	public static void main(String[] args) {
		String[] phone_book1 = {"119", "97674223", "1195524421"};
		String[] phone_book2 = {"123","456","789"};
		String[] phone_book3 = {"12","123","1235","567","88"};
		
		solution(phone_book1);
		System.out.println("---------------------------------------------------------------");
		solution(phone_book2);
		System.out.println("---------------------------------------------------------------");
		solution(phone_book3);
	}
	
	public static boolean solution(String[] phoneBook) {
		int i;
		int j;
		for(i=0; i<phoneBook.length-1; i++) {
			for(j=i+1; j<phoneBook.length; j++) {
				System.out.println("phoneBook[i] : " + phoneBook[i]);
				System.out.println("phoneBook[j] : " + phoneBook[j]);
				if(phoneBook[i].startsWith(phoneBook[j])) {
                    return false;
                }
				if(phoneBook[j].startsWith(phoneBook[i])) {
                    return false;
                }
			}
		}
		
		
		
		return true;
	}

}
