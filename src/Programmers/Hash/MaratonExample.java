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

		// 마라톤에 참여한 선수들 이름
		for (String player : participant) {
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		}

		// 완주한 선수들의 이름이 담긴 배열
		for (String edPlayer : completion) {
			hm.put(edPlayer, hm.get(edPlayer) - 1);
		}

		// 완주하지 못한 선수
		for (String nonPlayer : hm.keySet()) {
			System.out.println(hm.get(nonPlayer));
			if(!hm.get(nonPlayer).equals(0))
				answer = nonPlayer;
		}

		return answer;
	}

}
