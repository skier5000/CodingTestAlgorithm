package Programmers.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SoHot {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		// return 2;

		solution(scoville, K);
	}



	public static int mySolution(int[] scoville, int K) {
		// 변수선언
		int answer = 0;
		int i;
		int k;
		List list = new ArrayList<>();

		// ArrayList 에 스코빌 지수 넣기
		for(i=0; i<scoville.length; i++){
			list.add(scoville[i]);
		}

		// list에서 가장 낮은 값
//		System.out.println("min= " + Collections.min(list));
		for(i=0; i<list.size(); i++) {
			int minScoville = (int) list.get(i);
			System.out.println("minScoville : + " + minScoville);
			for(k=i+1; k<list.size(); k++) {
				if(minScoville > (int)list.get(k)) {
					System.out.println("list.get(k) : + " + list.get(k));
				}

			}
			System.out.println("===============================");
		}


		return answer;
	}



	public static int solution(int[] scoville, int K) {
		// 변수선언
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// PriorityQueue는 우선 순위 큐로서 가장 작은 숫자가 우선시 되게 기본으로 구현되어있다.
		// 즉, Min Heap이 구현되어 있는 것이다. Max Heap으로 사용하고 싶다면 Comparator로 내림차순 설정도 가능하다.

		for (int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}

		/*
			priorityQueue.poll();       // priorityQueue에 첫번째 값을 반환하고 제거 비어있다면 null
			priorityQueue.remove();     // priorityQueue에 첫번째 값 제거
			priorityQueue.clear();      // priorityQueue에 초기화
			priorityQueue.peek();       // priorityQueue에 첫번째 값 참조
		 */

		while (pq.peek() < K) {
			System.out.println("pq : " + pq);
			System.out.println("pq.peek() : " + pq.peek());
			System.out.println("pq.size() : " + pq.size());

			if (pq.size() < 2) {
				return -1;
			}

			int a = pq.poll();
			int b = pq.poll();
			pq.add(a + 2 * b);

			answer++;
		}

		return answer;
	}
}





