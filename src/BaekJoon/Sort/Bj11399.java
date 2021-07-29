package BaekJoon.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bj11399 {
/*
5
3 1 4 3 2
1 2 3 3 4
 */
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int result = 0;
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.println("result = " + result + "  arr[" + j + "] = " + arr[j]);
                result += arr[j];
                System.out.println("result = " + result);
                System.out.println(" ");
            }
        }

        System.out.println("result = " + result);
    }
}