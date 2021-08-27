package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
4
-1
2
1
3
 */
public class Bj1744 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int sum = 0;
//        int N = scanner.nextInt();
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//
//        for (int i = 0; i < N; i++) {
//            priorityQueue.offer(scanner.nextInt());
//        }
//
//        while (!priorityQueue.isEmpty()) {
//            int x = priorityQueue.poll();
//            int y = priorityQueue.poll();
//
//            if (x < 0 && y < 0) { // 둘 다 음수
//                sum += (x * y);
//            } else if (x < 0 || y < 0) { // 둘 중 하나 음수
//                sum += (x + y);
//            } else {
//                sum += (x * y);
//            }
//        }
//
//        System.out.println(sum);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        long ans =0;

        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        ans = 0;
        // 0, 음수일 경우 처리
        for (; left < right ; left+=2) {
            if(arr[left] <1 && arr[left+1] < 1){
                ans += arr[left] * arr[left+1];
            }else{
                break;
            }
        }

        // 양수일 경우 처리
        for (; right >0; right-=2) {
            // 1과는 곱하지 않게 조건문 추가.
            if(arr[right] >1 && arr[right-1] > 1){
                ans += arr[right] * arr[right-1];
            }else{
                break;
            }
        }
        //남은 값들은 더해주기
        for (; right >= left; right--) {
            ans += arr[right];
        }
        System.out.println(ans);
    }

}
