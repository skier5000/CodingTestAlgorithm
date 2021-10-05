package BaekJoon.단계별로풀어보기.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10870 {

    static int value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        value = Integer.parseInt(br.readLine());

        System.out.println(Fibonacci(value));
    }

    public static int Fibonacci(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;

        return Fibonacci(N - 1) + Fibonacci(N - 2);
    }
}
