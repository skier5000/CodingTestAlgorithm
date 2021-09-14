package BaekJoon.단계별로풀어보기.큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < N+1; i++) {
            queue.offer(i);
        }

        while(!queue.isEmpty()) {

            if (queue.size() == 1) {
                System.out.println(queue.poll());
                break;
            }
            queue.poll();
            int poll = queue.poll();
            queue.offer(poll);

        }
    }
}
