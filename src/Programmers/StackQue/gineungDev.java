package Programmers.StackQue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class gineungDev {

	public static void main(String[] args) {
		int[] progresses1 = {93, 30, 55};
		int[] progresses2 = {95, 90, 99, 99, 80, 99};

		int[] speeds1 = {1, 30, 5};
		int[] speeds2 = {1, 1, 1, 1, 1, 1};

		// return [2, 1] / [1, 3, 2]

		//solution(progresses1, speeds1);
		solution(progresses1, speeds1);
		mySolution(progresses1, speeds1);
	}

	/*
	 *
	 *
	 *
	입출력 예 설명
	입출력 예 #1
	첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
	두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다. 하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
	세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.

	따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.

	입출력 예 #2
	모든 기능이 하루에 1%씩 작업이 가능하므로, 작업이 끝나기까지 남은 일수는 각각 5일, 10일, 1일, 1일, 20일, 1일입니다. 어떤 기능이 먼저 완성되었더라도 앞에 있는 모든 기능이 완성되지 않으면 배포가 불가능합니다.

	따라서 5일째에 1개의 기능, 10일째에 3개의 기능, 20일째에 2개의 기능이 배포됩니다.
	 *
	 *
	 *
	 */

	public static LinkedList<Integer> solution(int[] progresses, int[] speeds) {
		// 변수선언
		int val;
		int a;
		int b;
		int c=0;
		LinkedList<Integer> queue = new LinkedList<>();
		LinkedList<Integer> queueResult = new LinkedList<>();

		for(int i=0; i<progresses.length; i++) {
			a = 100-progresses[i];

			//System.out.println("progress 잔여 퍼센트 : " + (100-progresses[i]));
			//System.out.println("하루 기능 개발 퍼센트 : " + (speeds[i]));

			if(a%speeds[i] > 0) {
				val = (a/speeds[i]) + 1;
				//System.out.println("걸리는 시간(날짜) : " + val );
				queue.add(val);
			}else {
				val = (a/speeds[i]);
				//System.out.println("걸리는 시간(날짜) : " + val );
				queue.add(val);
			}

			//System.out.println("======================================================");
		}
		//System.out.println("queue : " + queue);

		System.out.println("queue : " + queue);
		System.out.println("====================================================================");

		for(int j=0; j<queue.size(); j++) {
			b = queue.poll();
			for(int k=0; k<queue.size(); k++) {
				c++;
				System.out.println("b : " + b);
				System.out.println(k + "번째 : " + queue.get(k));
				System.out.println("==================================");

				if(b < queue.get(k)) {
					queueResult.add(c);
					c=0;
					break;
				}

			}
		}

		System.out.println("queueResult : " + queueResult);

		return queueResult;
	}



	public static int[] mySolution(int[] progresses, int[] speeds) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = progresses.length - 1; i >= 0; i--) {
			stack.add((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0));
		}

		List<Integer> s = new ArrayList<Integer>();

		while (!stack.isEmpty()) {
			int cnt = 1;

			int top = stack.pop();

			while (!stack.isEmpty() && stack.peek() <= top) {
				cnt++;
				stack.pop();
			}

			s.add(cnt);
		}

		int[] answer = new int[s.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = s.get(i);
		}

		return answer;
	}

}




