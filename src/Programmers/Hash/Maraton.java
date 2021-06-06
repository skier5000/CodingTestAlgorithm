package Programmers.Hash;

import java.util.*;

public class Maraton {

	public static void main(String[] args) {
		String[] participant1 = {"leo", "kiki", "eden"};
		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};

		String[] completion1 = {"eden", "kiki"};
		String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
		String[] completion3 = {"stanko", "ana", "mislav"};

		StringBuffer sb1 = new StringBuffer(); // 멀티쓰레드 환경 (속도 ↓)
		StringBuilder sb2 = new StringBuilder(); // 단일쓰레드 환경 (속도 ↑)
		sb1.append(participant1);
		sb2.append(participant1).append("안녕");

		System.out.println("sb1 : " + sb1);
		System.out.println("sb2 : " + sb2);
		//return
		/*
		 * 1."leo"
		 * 2."vinko"
		 * 3."mislav"
		 */
		solution(participant3, completion3);

	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		System.out.println("participant : " + Arrays.toString(participant));
		System.out.println("completion : " + Arrays.toString(completion));
		// 해시맵에 넣기
		// for(A:B) → B에서 차례대로 객체를 꺼내서 A에다가 넣겠다
		// hashmap.getOrDefault → 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환한다.
		for (String player : participant) {
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		}
		System.out.println("hm : " + hm);

		for (String player : completion) {
			System.out.println("hm.get(player) : " + hm.get(player));
			hm.put(player, hm.get(player) - 1);
		}


		for (String key : hm.keySet()) {
			if (hm.get(key) != 0){
				answer = key;
			}
		}
		System.out.println("answer : " + answer);
		return answer;
	}



}


/*
public String solution(String[] participant, String[] completion) {
int i;

for(i=0; i<participant.length; i++) {
	
}

String answer = "";
return null;
}
*/