package BaekJoon.Sort;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

/*
3
7
13 10 12 11 10 11 12
5
2 4 5 7 9
8
6 6 6 6 6 6 6 6
 */
public class Bj11497 {

    static int t,n;
    static int arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while(t>0) {
            t--;
            n = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            arr = new int[n];
            String[] t = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(t[i]);
            }

            int ans[] = new int[n];
            int left = 0;
            int right = n-1;

            Arrays.sort(arr);

            for (int i = 0; i < n; i++) {
                if ((i % 2) != 0) {
                    ans[left] = arr[i];
                    left ++;
                }
                else {
                    ans[right] = arr[i];
                    right --;
                }
            }

            min = Math.abs(ans[0]-ans[n-1]);
            for(int i=1; i<n; i++) {
                min = Math.max(min, Math.abs(ans[i]-ans[i-1]));
            }
            System.out.println(min);
        }
    }

}
