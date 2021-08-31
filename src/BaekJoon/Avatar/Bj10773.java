package BaekJoon.Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N;
        N = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arrayList.add(Integer.valueOf(br.readLine()));
        }

        int result = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == 0 && i != 0) {
                arrayList.remove(i);
                arrayList.remove(i - 1);
                i = i - 2;
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            result += arrayList.get(i);
        }

        System.out.println(result);

    }
}
