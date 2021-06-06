package Programmers.StackQue;

import java.util.*;

public class Truck {

    public static void main(String args[]) {
        // 다리길이 : bridge_length
        // 견디는 무게 : weight

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        solution(bridge_length, weight, truck_weights);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0, i = 0;
        // 큐 생성
        LinkedList<Integer> queue = new LinkedList<>();

        // 길이만큼 큐에 0 을 집어넣음    queue = [0, 0]
        for (int j = 0; j < bridge_length; j++) {
            queue.offer(0);
        }


        while (!queue.isEmpty()) {
            int popped = queue.poll(); //해당 큐의 맨 앞에 있는(제일 먼저 저장된) 요소를 반환하고, 해당 요소를 큐에서 제거함.
            sum = sum - popped;

            if (i < truck_weights.length) {
                System.out.println(sum + truck_weights[i]);
                if (sum + truck_weights[i] <= weight) {
                    queue.offer(truck_weights[i]); // 해당 큐의 맨 뒤에 전달된 요소를 삽입함.
                    sum = sum + truck_weights[i];
                    i++;
                } else {
                    queue.offer(0);
                }
            }
            answer++;

        }
        return answer;
    }
}





















/*



    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0, i = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int j = 0; j < bridge_length; j++) {
            q.offer(0);
        }
        while (!q.isEmpty()) {
            int popped = q.poll();
            sum -= popped;
            if (i < truck_weights.length) {
                if (sum + truck_weights[i] <= weight) {
                    q.offer(truck_weights[i]);
                    sum += truck_weights[i];
                    i++;
                } else {
                    q.offer(0);
                }
            }
            answer++;
        }
        return answer;
    }



*/