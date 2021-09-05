package BaekJoon.단계별로풀어보기.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
6
(())())
(((()())()
(()())((()))
((()()(()))(((())))()
()()()()(()()())()
(()((())()(

 */
public class Boj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        char[][] charArr = new char[N][];

        for (int i = 0; i < N; i++) {
            charArr[i] = br.readLine().toCharArray();
        }

        String[] resultMap = new String[N];
        for (int i = 0; i < charArr.length; i++) {

            int cnt = 0;
            for (int j = 0; j < charArr[i].length; j++) {
                if (charArr[i][j] == '(') {
                    cnt ++;
                } else if (charArr[i][j] == ')') {
                    cnt --;
                    if (cnt < 0) {
                        resultMap[i] = "NO";
                        break;
                    }
                }
            }

            if (cnt == 0) {
                resultMap[i] = "YES";
            } else {
                resultMap[i] = "NO";
            }
        }

        for (int i = 0; i < resultMap.length; i++) {
            System.out.println(resultMap[i]);
        }


    }
}
