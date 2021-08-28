package Programmers.Sort;

import java.util.*;

public class ThisBiggestNumber {

	public static void main(String[] args) {
		int[] numbers1 = {6,10,2};  // [6102, 6210, 1062, 1026, 2610, 2106]
		int[] numbers2 = {3,30,34,5,9};

		//solution(numbers1);
		solution(numbers2);
	}



	private static String mySolution(int[] numbers) {
		String answer = "";
		int forNum = 1; // 경우의수
		int a = 0;
		int answerInt;

		// 경우의수 계산
		for(int i=0; i<numbers.length; i++) {
			forNum = forNum * (i+1);
		}
		System.out.println("forNum (총 경우의 수) : " + forNum);

		int[] val = new int[forNum];

		// main (경우의 수 만큼 조합)
		for(int j=0; j<forNum; j++) {
			val[a] = j;
			System.out.println("val[a]: " + val[a]);
			a++;
		}

		Arrays.sort(val);
		answerInt = val[val.length-1];
		answer = Integer.toString(answerInt);
		System.out.println(answerInt);

		return answer;
	}





	public static String solution(int[] numbers) {
		String answer = "";

		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}

		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String as = String.valueOf(o1);
				String bs = String.valueOf(o2);
				return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
			}
		});


		StringBuilder sb = new StringBuilder();
		for(Integer i : list) {
			sb.append(i);
		}

		answer = sb.toString();
		if(answer.charAt(0) == '0') {
			System.out.println(answer);
			return "0";
		}else {
			System.out.println(answer);
			return answer;
		}
	}

}
