package BaekJoon.단계별로풀어보기.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] s1 = s.split(" ");

            if (s1[0].equals("push")) {
                stack.push(s1[1]);
            } else if (s1[0].equals("pop")) {
                if (stack.size() == 0) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.pop());
                }
            } else if (s1[0].equals("size")) {
                System.out.println(stack.size());
            } else if (s1[0].equals("empty")) {
                if (stack.size() == 0) {
                    System.out.println("1");
                } else if (stack.size() != 0) {
                    System.out.println("0");
                }
            } else if (s1[0].equals("top")) {
                if (stack.size() == 0) {
                    System.out.println("-1");
                } else if (stack.size() != 0) {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
