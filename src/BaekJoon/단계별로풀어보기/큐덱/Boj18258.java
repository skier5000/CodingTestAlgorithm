package BaekJoon.단계별로풀어보기.큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj18258 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        Queue<Integer> queue = new LinkedList<>();
//        int i = 0;
//
//        for (i = 0; i < N; i++) {
//            String[] s = br.readLine().split(" ");
//
//            if (s.length > 1) {
//                queue.offer(Integer.valueOf(s[1]));
//            } else {
//
//                if (s[0].equals("pop")) {
//                    if (queue.size() == 0) {
//                        System.out.println("-1");
//                    } else {
//                        System.out.println(queue.poll());
//                    }
//                } else if (s[0].equals("size")) {
//                    System.out.println(queue.size());
//                } else if (s[0].equals("empty")) {
//                    if (queue.size() == 0) {
//                        System.out.println("1");
//                    } else {
//                        System.out.println("0");
//                    }
//                } else if (s[0].equals("front")) {
//                    if (queue.toArray().length > 0) {
//                        System.out.println(queue.toArray()[0]);
//                    } else {
//                        System.out.println("-1");
//                    }
//                } else if (s[0].equals("back")) {
//                    if (queue.toArray().length > 0) {
//                        System.out.println(queue.toArray()[queue.toArray().length-1]);
//                    } else {
//                        System.out.println("-1");
//                    }
//                }
//
//            }
//
//
//        }
//    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer command;

        while(N-- > 0) {
            command = new StringTokenizer(br.readLine(), " ");	// 문자열 분리

            switch(command.nextToken()) {

                case "push":
                    // offer는 큐의 맨 뒤에 요소를 추가한다.
                    q.offer(Integer.parseInt(command.nextToken()));
                    break;

                case "pop" :
                    /*
                     *  poll은 가장 앞에 있는 요소를 삭제하며
                     *  삭제할 원소가 없을 경우 예외를 던지는 것이 아닌 null을 반환한다.
                     */
                    Integer item = q.poll();
                    if(item == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(item).append('\n');
                    }
                    break;

                case "size":
                    sb.append(q.size()).append('\n');
                    break;

                case "empty":
                    if(q.isEmpty()) {
                        sb.append(1).append('\n');
                    }
                    else {
                        sb.append(0).append('\n');
                    }
                    break;

                case "front":
                    // peek()은 큐에 꺼낼 요소가 없을 경우 null을 반환한다.
                    Integer ite = q.peek();
                    if(ite == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(ite).append('\n');
                    }
                    break;

                case "back":
                    // peekLast()은 큐에 꺼낼 요소가 없을 경우 null을 반환한다.
                    Integer it = q.peekLast();
                    if(it == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(it).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
