package Programmers.StackQue;

import java.util.LinkedList;
import java.util.Queue;

public class TruckExample {
    public static void main(String args[]) {
        // 다리길이 : bridge_length
        // 견디는 무게 : weight


        TruckExample truckExample = new TruckExample();

        truckExample.solution(2, 10, new int[] {7,4,5,6});
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0, j = 0, answer = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            queue.offer(truck_weights[i]);
        }

        while (!queue.isEmpty()) {
            int popped = queue.poll(); //해당 큐의 맨 앞에 있는(제일 먼저 저장된) 요소를 반환하고, 해당 요소를 큐에서 제거함.
            sum = sum - popped;

            if (j < truck_weights.length) {
                System.out.println(sum + truck_weights[j]);
                if (sum + truck_weights[j] <= weight) {
                    queue.offer(truck_weights[j]); // 해당 큐의 맨 뒤에 전달된 요소를 삽입함.
                    sum = sum + truck_weights[j];
                    j++;
                } else {
                    queue.offer(0);
                }
            }
            answer++;
        }



        return answer;
    }
}
