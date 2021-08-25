package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
5
ABCD
145C
A
A910
Z321
 */
public class Bj1431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] matrix = new String[t];

        for (int i = 0; i < t; i++) {
            matrix[i] = br.readLine();
        }

        br.close();

        Arrays.sort(matrix, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                // 길이가 짧은 걸 먼저 정렬
                if (o1.length() < o2.length()) {
                    return o1.length() < o2.length() ? -1 : 1;
                }

                // 길이가 같으면 숫자 합이 작은걸 먼저 정렬
                if (o1.length() == o2.length()) {
                    int sum1 = 0;
                    int sum2 = 0;

                    for (char ch : o1.toCharArray()) {
                        if(ch >= 'A') continue;
                        sum1 += ch-'0';
                    }
                    for (char ch : o2.toCharArray()) {
                        if(ch >= 'A') continue;
                        sum2 += ch - '0';
                    }
                    if (sum1 < sum2)
                        return -1;
                    if (sum2 < sum1)
                        return 1;
                }

                // 사전순으로 정렬
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) < o2.charAt(i))
                        return -1;
                    if (o2.charAt(i) < o1.charAt(i))
                        return 1;
                }
                return 0;
            }
        });

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i]);
        }


    }
}
