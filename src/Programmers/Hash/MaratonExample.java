package Programmers.Hash;

import java.util.HashMap;

public class MaratonExample {

	public static void main(String[] args) {
		String[] participant1 = {"leo", "kiki", "eden"};
		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};

		String[] completion1 = {"eden", "kiki"};
		String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
		String[] completion3 = {"stanko", "ana", "mislav"};

		mySolution(participant1, completion1);
	}


	public static String mySolution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();

		for(String player : participant) {
			hm.put(player, hm.getOrDefault(player, 0) + 1);  //찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환한다.
		}

		// hm = {leo=1, eden=1, kiki=1}
		for(String player : completion) {
			hm.put(player, hm.getOrDefault(player, 0) -1);
		}

		// hm = {leo=1, eden=0, kiki=0}

		for (String key : hm.keySet()) {
			if (hm.get(key) == 1){
				answer = key;
			}
		}


		return answer;
	}

}
