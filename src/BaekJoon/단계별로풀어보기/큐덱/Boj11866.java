package BaekJoon.단계별로풀어보기.큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj11866 {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int k = 1; k < N+1; k++) {
            queue.offer(k);
        }

        sb.append("<");

        while(queue.size() > 1) {

            for(int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }

            sb.append(queue.poll()).append(", ");
        }

        sb.append(queue.poll()).append('>');
        System.out.println(sb);


    }


}
