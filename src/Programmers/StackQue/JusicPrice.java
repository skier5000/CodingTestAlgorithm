package Programmers.StackQue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JusicPrice {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		// return [4, 3, 1, 1, 0]
		
		solution(prices);
	}
	
	
/*
	문제 설명
	초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

	제한사항
	prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
	prices의 길이는 2 이상 100,000 이하입니다.
	입출력 예
	prices	return
	[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
	입출력 예 설명
	1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
	2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
	3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
	4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
	5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.  =>  마지막은 무조건 0초간 가격이 떨어지지않음
*/
	
	public static int[] solution(int[] prices) {
		// 변수 선언
		int[] answer = new int[prices.length];
		int i;
		int j;
		System.out.println(Arrays.toString(prices));
		System.out.println("========================================");
		
		
		for(i=0;i<prices.length-1;i++) {
			for(j=i+1; j<prices.length; j++) {
				// 다음 배열값이 본인보다 큰 경우
				if(prices[i] <= prices[j]) {
					//System.out.println("i : " + prices[i] + " / j : " + prices[j]);
				}
				// 다음 배열값이 본인보다 작은 경우
				if(prices[i] > prices[j]) {
					//System.out.println("i : " + prices[i] + " / j : " + prices[j] + " 가격 떨어짐");
					break;
				}
			}
			
			if(j == prices.length) {
				System.out.println((i+1) + "초 시점   " + (j-(i+1)) + "초간 가격이 떨어지지않습니다.");
				answer[i] = (j-(i+1));
			}
			else {
				System.out.println((i+1) + "초 시점   " + (j-i) + "초간 가격이 떨어지지않습니다.");
				answer[i] = j-i;
			}
			
		}
		
		
		System.out.println("결과 : " + Arrays.toString(answer));
		return answer;
	}
	
	
	

}


