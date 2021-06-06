package Programmers.Sort;

import java.util.Arrays;
import java.util.HashMap;

public class Knumber {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

		solution(array, commands);
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int a = 0;
		for(int[] info : commands){
			int i = info[0];
			int j = info[1];
			int k = info[2];

			int[] buf = Arrays.copyOfRange(array,i-1,j); // array 배열을 i-1 번째 인덱스부터 j-1 인덱스 까지 (마지막 j 는 -1 번째 인덱스까지만 복사)
			Arrays.sort(buf);
			answer[a] = buf[k-1];
			a++;
		}
		System.out.println("answer : " + Arrays.toString(answer));
		return answer;

	}

}
