package BaekJoon.단계별로풀어보기.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10872 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = factorial(N);
        System.out.println(sum);

    }

    public static int factorial(int N) {
        if(N <= 1)
            return 1;	// 재귀 종료조건

        return N * factorial(N - 1);
    }
}
