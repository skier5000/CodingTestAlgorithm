package BaekJoon.Sort;

import java.io.*;
import java.util.*;

/*
10
1 4 2 3 1 4 2 3 1 2
 */
public class Bj10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrayList = new ArrayList();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (!arrayList.contains(number)) {
                arrayList.add(number);
            }
        }

        Collections.sort(arrayList);

        for (Integer integer : arrayList) {
            System.out.print(integer + " ");
        }
    }
}
